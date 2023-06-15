package com.wg2.storefront.products

import io.javalin.http.Context

object ProductController {

    data class Product(
        val id: String,
        val name: String,
        val description: String,
        val iconUrl: String,
        val bannerUrl: String,
        val price: Double,
        val enabled: Boolean,
    )

    val products = listOf(
        Product(
            "1",
            "Callmaster",
            "This is the best product. You should buy it.",
            "https://picsum.photos/id/100/200",
            "https://picsum.photos/id/101/800/400",
            4.49,
            false
        ),
        Product(
            "2",
            "Spamomatic",
            "This is the second best product. You should buy it.",
            "https://picsum.photos/id/200/200",
            "https://picsum.photos/id/201/800/400",
            0.99,
            false
        ),
        Product(
            "3",
            "Messagealot",
            "This is the third best product. You should buy it.",
            "https://picsum.photos/id/300/200",
            "https://picsum.photos/id/301/800/400",
            2.99,
            true
        )
    )

    fun listAvailableProducts(ctx: Context) {
        ctx.json(products)
    }

}
