package com.wg2.storefront.products

data class Product(
        val id: String,
        val name: String,
        val description: String,
        val iconUrl: String,
        val bannerUrl: String,
        val price: Double,
        val enabled: Boolean,
    )
