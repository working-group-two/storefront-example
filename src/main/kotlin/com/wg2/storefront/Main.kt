package com.wg2.storefront

import com.wg2.storefront.auth.AccessManager
import com.wg2.storefront.auth.Role
import com.wg2.storefront.auth.currentUser
import com.wg2.storefront.consents.ConsentController
import com.wg2.storefront.consents.ConsentService
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
        it.jetty.modifyServletContextHandler { servletContext ->
            servletContext.sessionHandler = AccessManager.sessionHandler
        }
        it.vue.stateFunction = { ctx ->
            mapOf(
                "currentUser" to ctx.currentUser,
                // we need user consents on basically every page, so we put it in the global state
                "userConsents" to (ctx.currentUser?.let { ConsentService.getConsentsForSubscription(it) } ?: emptyList()),
            )
        }
        it.router.mount { it.beforeMatched(AccessManager::manage) }
        it.router.apiBuilder {
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
                    get(ConsentController::listConsentsForSubscription, Role.SIGNED_IN)
                    delete("/revoke", ConsentController::revokeConsentForSubscription, Role.SIGNED_IN)
                    post("/create", ConsentController::createConsentForSubscription, Role.SIGNED_IN)
                }
                path("/products") {
                    get(ProductController::listAvailableProducts, Role.SIGNED_IN)
                    path("{productId}") {
                        get(ProductController::listOne, Role.SIGNED_IN)
                    }
                }
            }
        }
    }.start(Config.port)

    Runtime.getRuntime().addShutdownHook(
        Thread {
            app.stop()
            GrpcShared.close()
        },
    )
}
