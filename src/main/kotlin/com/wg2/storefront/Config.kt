package com.wg2.storefront

object Config {
    val port = System.getenv("PORT")?.toInt() ?: 7070
    val useSandboxApis = System.getenv("USE_SANDBOX_APIS")?.toBoolean() ?: true

    val apiClientId = System.getenv("API_CLIENT_ID") ?: "666ea683-4e87-48ed-93ec-a44436957a63"
    val apiClientSecret = System.getenv("API_CLIENT_SECRET") ?: "yolo"
    val apiTarget = System.getenv("API_TARGET") ?: "api.wgtwo.com"
}
