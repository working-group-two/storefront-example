package com.wg2.storefront.consents

import com.wg2.storefront.auth.signedInUser
import io.javalin.http.BadRequestResponse
import io.javalin.http.Context

object ConsentController {

    fun listConsentsForSubscriber(ctx: Context) {
        val phoneNumber = ctx.signedInUser
        val consents = ConsentService.getConsentsForSubscriber(phoneNumber)
        ctx.json(consents)
    }

    fun revokeConsentForSubscriber(ctx: Context) {
        val phoneNumber = ctx.signedInUser
        val productId = ctx.queryParam("productId") ?: throw BadRequestResponse("Missing product ID")
        ConsentService.revokeConsentForSubscriber(phoneNumber, productId)
    }

    fun createConsentForSubscriber(ctx: Context) {
        val phoneNumber = ctx.signedInUser
        val productId = ctx.queryParam("productId") ?: throw BadRequestResponse("Missing product ID")
        val productVersion = ctx.queryParam("productVersion") ?: throw BadRequestResponse("Missing product Version")
        ConsentService.createConsentForSubscriber(phoneNumber, productId, productVersion)
    }

}
