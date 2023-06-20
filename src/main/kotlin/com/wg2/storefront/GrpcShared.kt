package com.wg2.storefront

import com.wg2.storefront.auth.AuthInterceptor
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import java.util.concurrent.TimeUnit

object GrpcShared {

    val authInterceptor = AuthInterceptor(Config.apiClientId, Config.apiClientSecret)

    val channel: ManagedChannel = ManagedChannelBuilder.forAddress(Config.apiTarget, 443)
        .useTransportSecurity()
        .keepAliveTime(30, TimeUnit.SECONDS)
        .keepAliveTimeout(10, TimeUnit.SECONDS)
        .keepAliveWithoutCalls(true)
        .build()

    fun close() {
        channel.shutdown()
        channel.awaitTermination(1, TimeUnit.SECONDS)
    }
}
