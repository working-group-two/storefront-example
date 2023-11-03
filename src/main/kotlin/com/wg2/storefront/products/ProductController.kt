package com.wg2.storefront.products

import io.javalin.http.Context
import io.javalin.http.NotFoundResponse

object ProductController {

    // This should depend on the logged-in user in a multi tenant scenario
    private final val TENANT = "wotel"

    fun listAvailableProducts(ctx: Context) {
        ctx.json(ProductService.listProducts(TENANT))
    }

    fun listOne(ctx: Context) {
        val productId = ctx.pathParam("productId")
        val product = ProductService.listProducts(TENANT).find { it.id == productId } ?: throw NotFoundResponse()
        ctx.json(product)
    }

}
