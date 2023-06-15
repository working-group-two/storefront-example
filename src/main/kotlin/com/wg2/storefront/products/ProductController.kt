package com.wg2.storefront.products

import io.javalin.http.Context

object ProductController {

    data class Product(val id: String, val name: String, val description: String, val iconUrl: String, val bannerUrl: String, val price: Double)

    fun listAvailableProducts(ctx: Context) {
        val products = listOf(
            Product("1", "The Best Product", "This is the best product. You should buy it.", "https://picsum.photos/id/100/200", "https://picsum.photos/id/101/800/400", 4.49),
            Product("2", "The Second Best Product", "This is the second best product. You should buy it.", "https://picsum.photos/id/200/200", "https://picsum.photos/id/201/800/400", 0.99),
            Product("3", "The Third Best Product", "This is the third best product. You should buy it.", "https://picsum.photos/id/300/200", "https://picsum.photos/id/301/800/400", 2.99)
        )
        ctx.json(products)
    }

}
