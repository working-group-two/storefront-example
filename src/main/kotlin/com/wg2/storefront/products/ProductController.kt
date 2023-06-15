package com.wg2.storefront.products

import io.javalin.http.Context
import io.javalin.http.NotFoundResponse

object ProductController {

    fun listAvailableProducts(ctx: Context) {
        //TODO need to know subscriber tenant
        ctx.json(ProductService.listProducts())
    }

    fun listOne(ctx: Context) {
        val productId = ctx.pathParam("productId")
        val product = ProductService.getProduct(productId) ?: throw NotFoundResponse()
        ctx.json(product)
    }

}
