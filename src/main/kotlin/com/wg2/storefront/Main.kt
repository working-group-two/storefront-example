package com.wg2.storefront

import com.wg2.storefront.auth.AccessManager
import com.wg2.storefront.auth.Role
import com.wg2.storefront.consents.ConsentController
import com.wg2.storefront.products.ProductController
import com.wg2.storefront.signin.SigninHandler
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.delete
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
        get("/sign-in", VueComponent("sign-in-page"), Role.ANY)
        get("/", VueComponent("storefront-page"), Role.SIGNED_IN)
        get("/p/{productId}", VueComponent("product-details-page"), Role.SIGNED_IN)
        get("/profile", VueComponent("profile-page"), Role.SIGNED_IN)
        path("/api") {
            path("/auth") {
                post("/send-pin", SigninHandler::sendPin, Role.ANY)
                post("/validate-pin", SigninHandler::validatePin, Role.ANY)
            }
            path("/consents") {
                get(ConsentController::listConsentsForSubscriber, Role.SIGNED_IN)
                delete("/revoke", ConsentController::revokeConsentForSubscriber, Role.SIGNED_IN)
                post("/create", ConsentController::createConsentForSubscriber, Role.SIGNED_IN)
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
