package com.wg2.storefront.consents

import com.wg2.storefront.auth.signedInUser
import io.javalin.http.BadRequestResponse
import io.javalin.http.Context

object ConsentController {

    fun listConsentsForSubscription(ctx: Context) {
        val phoneNumber = ctx.signedInUser
        val consents = ConsentService.getConsentsForSubscription(phoneNumber)
        ctx.json(consents)
    }

    fun revokeConsentForSubscription(ctx: Context) {
        val phoneNumber = ctx.signedInUser
        val productId = ctx.queryParam("productId") ?: throw BadRequestResponse("Missing product ID")
        ConsentService.revokeConsentForSubscription(phoneNumber, productId)
    }

    fun createConsentForSubscription(ctx: Context) {
        val phoneNumber = ctx.signedInUser
        val productId = ctx.queryParam("productId") ?: throw BadRequestResponse("Missing product ID")
        ConsentService.createConsentForSubscription(phoneNumber, productId)
    }

}
