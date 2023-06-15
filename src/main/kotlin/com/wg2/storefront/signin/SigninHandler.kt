package com.wg2.storefront.signin

import io.javalin.http.Context

object SigninHandler {

    fun sendPin(ctx: Context) {
        if (Math.random() > 0.5) {
            ctx.status(500)
            ctx.json(mapOf("message" to "Something went wrong"))
        } else {
            ctx.status(200)
            ctx.json(mapOf("message" to "Pin sent"))
        }
    }

    fun validatePin(ctx: Context) {
        if (Math.random() > 0.5) {
            ctx.status(500)
            ctx.json(mapOf("message" to "Something went wrong"))
        } else {
            ctx.status(200)
            ctx.json(mapOf("message" to "Pin validated"))
        }
    }
}
