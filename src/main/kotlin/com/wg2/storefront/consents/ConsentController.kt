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

}
