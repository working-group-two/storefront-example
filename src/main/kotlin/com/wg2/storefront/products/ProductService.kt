package com.wg2.storefront.products

import com.wg2.storefront.GrpcShared
import com.wgtwo.api.v0.products.ProductServiceGrpc
import com.wgtwo.api.v0.products.ProductsProto
import com.wgtwo.api.v0.products.ProductsProto.ListProductsForTenantRequest
import org.slf4j.LoggerFactory

data class Product(
    val id: String,
    val name: String,
    val subtitle: String,
    val description: String,
    val productUrl: String,
    val iconImageId: Long = 903, //TODO: Remove this
)

object ProductService {

    private val logger by lazy { LoggerFactory.getLogger(javaClass) }
    private val productsStub = ProductServiceGrpc
        .newBlockingStub(GrpcShared.channel)
        .withInterceptors(GrpcShared.authInterceptor)

    // TODO: Should cache this
    fun listProducts(tenant: String): List<Product> {
        val request = ListProductsForTenantRequest.newBuilder().apply {
            this.tenant = tenant
        }.build()

        val response = productsStub.listProductsForTenant(request)
        return response.productsList.map { it.toProduct() }
    }

    private fun ProductsProto.Product.toProduct() = Product(
        id = id,
        name = name,
        subtitle = subtitle,
        description = description,
        productUrl = productUrl,
    )

}
