package com.wg2.storefront.signin

import com.wg2.storefront.auth.AccessManager
import com.wg2.storefront.sms.SmsService
import io.javalin.http.Context
import io.javalin.http.InternalServerErrorResponse
import io.javalin.http.UnauthorizedResponse
import io.javalin.http.util.NaiveRateLimit
import org.slf4j.LoggerFactory
import java.security.SecureRandom
import java.time.Duration
import java.time.Instant
import java.util.concurrent.TimeUnit

object SigninHandler {
    private val logger by lazy { LoggerFactory.getLogger(javaClass) }

    private const val PIN_TIME_KEY = "sent-pin-timestamp"
    private const val PIN_KEY = "sent-pin"
    private const val PHONE_NUMBER_KEY = "entered-phone-number"

    fun sendPin(ctx: Context) {
        NaiveRateLimit.requestPerTimeUnit(ctx, 20, TimeUnit.HOURS)
        val phoneNumber = ctx.queryParam("phoneNumber")
        val randomPin = SecureRandom().nextInt(10000).toString().padStart(4, '0')
        ctx.sessionAttribute(PHONE_NUMBER_KEY, phoneNumber)
        ctx.sessionAttribute(PIN_KEY, randomPin)
        ctx.sessionAttribute(PIN_TIME_KEY, Instant.now())
        val smsContent = "$randomPin is your Wotel Storefront authentication code."
        try {
            logger.info("Sending SMS to $phoneNumber: $smsContent")
            // send sms
            SmsService.sendToSubscriber(phoneNumber!!, smsContent)
            ctx.status(200)
        } catch (e: Exception) {
            logger.error("Error sending PIN", e)
            throw UnauthorizedResponse() // needs to be enabled by operator
            throw InternalServerErrorResponse() // use for any other kind of error
        }
    }

    fun validatePin(ctx: Context) {
        NaiveRateLimit.requestPerTimeUnit(ctx, 20, TimeUnit.HOURS)
        val pin = ctx.queryParam("pin")
        val sentPin = ctx.consumeSessionAttribute<String>(PIN_KEY) ?: throw InternalServerErrorResponse()
        val sentPinTime = ctx.consumeSessionAttribute<Instant>(PIN_TIME_KEY) ?: throw InternalServerErrorResponse()
        if (pin == sentPin && sentPinTime.durationAge() < Duration.ofHours(1)) {
            val phoneNumberString = ctx.consumeSessionAttribute<String>(PHONE_NUMBER_KEY)!!
            AccessManager.signUserIn(ctx, phoneNumberString)
        } else {
            throw InternalServerErrorResponse()
        }
    }

}


fun Instant.durationAge(): Duration = Duration.between(this, Instant.now())
