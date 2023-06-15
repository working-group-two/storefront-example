package com.wg2.storefront.products

object ProductService {

    private val products = listOf(
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
            "Messyboi",
            "This is the third best product. You should buy it.",
            "https://picsum.photos/id/300/200",
            "https://picsum.photos/id/301/800/400",
            2.99,
            true
        )
    )

    fun listProducts(): List<Product> = products
    fun getProduct(id: String): Product? = products.find { it.id == id }

}
