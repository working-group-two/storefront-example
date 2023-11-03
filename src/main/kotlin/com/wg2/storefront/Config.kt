package com.wg2.storefront

object Config {
    val port = System.getenv("PORT")?.toInt() ?: 7070
    val useSandboxApis = System.getenv("USE_SANDBOX_APIS")?.toBoolean() ?: true

    val apiClientId = System.getenv("API_CLIENT_ID") ?: ""
    val apiClientSecret = System.getenv("API_CLIENT_SECRET") ?: ""
    val apiTarget = System.getenv("API_TARGET") ?: "api.wgtwo.com"
}
