package com.wg2.storefront.products

import io.javalin.http.Context

object ProductController {

    fun listAvailableProducts(ctx: Context) {
        ctx.json(ProductService.products)
    }

}
