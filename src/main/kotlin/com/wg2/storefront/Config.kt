package com.wg2.storefront

object Config {
    val port = System.getenv("PORT")?.toInt() ?: 7070
    val useSandboxApis = System.getenv("USE_SANDBOX_APIS")?.toBoolean() ?: true
}
