package com.wg2.storefront.signin

import io.javalin.http.Context

object SigninHandler {

    fun sendPin(ctx: Context) {
        val statuses = setOf(200, 401, 500)
        ctx.status(statuses.shuffled().first())
    }

    fun validatePin(ctx: Context) {
        val statuses = setOf(200, 500)
        ctx.status(statuses.shuffled().first())
    }
}
