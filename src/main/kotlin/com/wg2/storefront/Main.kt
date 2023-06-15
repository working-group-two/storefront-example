package com.wg2.storefront

import com.wg2.storefront.products.ProductController
import com.wg2.storefront.service.GrpcShared
import com.wg2.storefront.signin.SigninHandler
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.ApiBuilder.post
import io.javalin.vue.VueComponent

fun main() {

    val app = Javalin.create {
        it.staticFiles.enableWebjars()
        it.staticFiles.add("/public")
        it.accessManager(AccessManager::manage)
        it.jetty.sessionHandler(AccessManager::sessionHandler)
    }.routes {
        get("/", VueComponent("storefront-page"), Role.SIGNED_IN)
        get("/p/{productId}", VueComponent("product-details-page"), Role.SIGNED_IN)
        get("/sign-in", VueComponent("sign-in-page"), Role.ANY)
        path("/api") {
            path("/auth") {
                post("/send-pin", SigninHandler::sendPin, Role.ANY)
                post("/validate-pin", SigninHandler::validatePin, Role.ANY)
            }
            path("/products") {
                get(ProductController::listAvailableProducts, Role.SIGNED_IN)
                path("{productId}") {
                    get(ProductController::listOne, Role.SIGNED_IN)
                }
            }
        }
    }.start(Config.port)

    Runtime.getRuntime().addShutdownHook(Thread {
        app.stop()
        GrpcShared.close()
    })

}
