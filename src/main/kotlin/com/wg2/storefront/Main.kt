package com.wg2.storefront

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
        get("/") { ctx -> ctx.result("Hello World") }
        get("/sign-in", VueComponent("sign-in"), Role.ANY)
        path("/api") {
            path("/auth") {
                post("/send-pin", SigninHandler::sendPin, Role.ANY)
                post("/validate-pin", SigninHandler::validatePin, Role.ANY)
            }
        }
    }.start(Config.port)

    Runtime.getRuntime().addShutdownHook(Thread {
        app.stop()
    })

}
