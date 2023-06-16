package com.wg2.storefront.auth

import io.javalin.http.Context
import io.javalin.http.Handler
import io.javalin.http.UnauthorizedResponse
import io.javalin.security.RouteRole
import org.eclipse.jetty.server.session.DefaultSessionCache
import org.eclipse.jetty.server.session.FileSessionDataStore
import org.eclipse.jetty.server.session.SessionHandler
import java.io.File

enum class Role : RouteRole { SIGNED_IN, ANY }

const val USER_KEY = "current-user"
const val LOGIN_REDIRECT_KEY = "post-login-redirect"
val Context.currentUser: String? get() = this.sessionAttribute<String>(USER_KEY)
val Context.signedInUser: String get() = currentUser!!

object AccessManager {

    val sessionHandler = fileSessionHandler()

    fun manage(handler: Handler, ctx: Context, permittedRoles: Set<RouteRole>) {
        when {
            Role.ANY in permittedRoles -> handler.handle(ctx)
            ctx.currentUser == null -> {
                ctx.sessionAttribute(LOGIN_REDIRECT_KEY, ctx.fullUrl())
                ctx.redirect("/sign-in")
            }
            Role.SIGNED_IN in permittedRoles -> handler.handle(ctx)
            else -> throw UnauthorizedResponse()
        }
    }

    fun signUserIn(ctx: Context, phoneNumber: String) {
        if (ctx.req().getSession(false) != null) {
            ctx.req().changeSessionId()
        }
        ctx.sessionAttribute(USER_KEY, phoneNumber)
    }

    fun signOutUser(ctx: Context) {
        ctx.sessionAttribute(USER_KEY, null)
        ctx.req().changeSessionId()
    }

}

private fun fileSessionHandler(): SessionHandler = SessionHandler().apply {
    sessionCache = DefaultSessionCache(this).apply {
        sessionDataStore = FileSessionDataStore().apply {
            val baseDir = File(System.getProperty("java.io.tmpdir"))
            this.storeDir = File(baseDir, "storefront-session-store").apply { mkdir() }
        }
    }
    sessionCookieConfig.isHttpOnly = true
    sessionCookieConfig.isSecure = false // file session handler is only used for development
}
