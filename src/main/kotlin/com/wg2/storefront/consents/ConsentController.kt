package com.wg2.storefront.consents

import com.wg2.storefront.auth.currentUser
import io.javalin.http.Context

object ConsentController {

    fun listConsentsForSubscriber(ctx: Context) {
        assert(ctx.currentUser != null) { "Not logged in" }
        val phoneNumber = ctx.currentUser!!
        val consents = ConsentService.getConsentsForSubscriber(phoneNumber)
        ctx.json(consents)
    }

    fun revokeConsentForSubscriber(ctx: Context) {
        assert(ctx.currentUser != null) { "Not logged in" }
        val phoneNumber = ctx.currentUser!!
        val productId = ctx.pathParam("productId")
        ConsentService.revokeConsentForSubscriber(phoneNumber, productId)
    }

    fun createConsentForSubscriber(ctx: Context) {
        assert(ctx.currentUser != null) { "Not logged in" }
        val phoneNumber = ctx.currentUser!!
        val productId = ctx.pathParam("productId")
        val productVersion = ctx.pathParam("productVersion")
        ConsentService.createConsentForSubscriber(phoneNumber, productId, productVersion)
    }

}
