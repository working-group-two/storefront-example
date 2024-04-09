package com.wg2.storefront.products

import com.wg2.storefront.GrpcShared
import com.wgtwo.api.v0.images.ImagesProto
import com.wgtwo.api.v0.products.ProductServiceGrpc
import com.wgtwo.api.v0.products.ProductsProto
import com.wgtwo.api.v0.products.ProductsProto.ListProductsForTenantRequest
import org.slf4j.LoggerFactory
import java.net.URL

data class Product(
    val id: String,
    val name: String,
    val subtitle: String,
    val description: String,
    val productUrl: String,
    val icon: Image,
    val banner: Image,
    val images: List<Image>,
)

data class Image(val url: String)

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
        icon = icon.toImage(),
        banner = banner.toImage(),
        images = imagesList.map { it.toImage() }
        // if you want to use random images, replace the above line with the following:
//        images = (1..8).map {
//            Image("https://picsum.photos/1024/512?random=$it")
//        }
    )

    private fun ImagesProto.Image.toImage() = Image(url)

}
