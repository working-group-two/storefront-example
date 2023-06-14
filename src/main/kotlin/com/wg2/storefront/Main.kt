package com.wg2.storefront

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
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
    }.start(Config.port)

    Runtime.getRuntime().addShutdownHook(Thread {
        app.stop()
    })

}
