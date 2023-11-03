package com.wg2.storefront.consents

import com.wg2.storefront.GrpcShared
import com.wg2.storefront.PhoneNumber
import com.wgtwo.api.v0.common.ErrorsProto
import com.wgtwo.api.v0.consent.ConsentServiceGrpc
import com.wgtwo.api.v0.consent.ConsentsProto.CreateConsentForSubscriptionRequest
import com.wgtwo.api.v0.consent.ConsentsProto.GetConsentsForSubscriptionRequest
import com.wgtwo.api.v0.consent.ConsentsProto.RevokeConsentForSubscriptionRequest
import org.slf4j.LoggerFactory

object ConsentService {
    private val logger by lazy { LoggerFactory.getLogger(javaClass) }
    private val consentStub = ConsentServiceGrpc.newBlockingStub(GrpcShared.channel).withInterceptors(GrpcShared.authInterceptor)

    fun getConsentsForSubscription(phoneNumber: PhoneNumber): List<Consent> {
        val request = GetConsentsForSubscriptionRequest.newBuilder().apply {
            this.phoneNumber = phoneNumber.toProto()
        }.build()

        val response = consentStub.getConsentsForSubscription(request)

        return when (response.statusCode) {
            ErrorsProto.StatusCode.STATUS_CODE_OK -> response.consentsList.map { Consent.fromProto(it) }
            else -> throw RuntimeException(response.errorMessage)
        }
    }

    fun createConsentForSubscription(phoneNumber: PhoneNumber, productId: String) {
        val request = CreateConsentForSubscriptionRequest.newBuilder().apply {
            this.phoneNumber = phoneNumber.toProto()
            this.productId = productId
         }.build()

         val response = consentStub.createConsentForSubscription(request)
         if (response.statusCode != ErrorsProto.StatusCode.STATUS_CODE_OK) {
             throw RuntimeException(response.errorMessage)
         }
    }

    fun revokeConsentForSubscription(phoneNumber: PhoneNumber, productId: String) {
        val request = RevokeConsentForSubscriptionRequest.newBuilder().apply {
            this.phoneNumber = phoneNumber.toProto()
            this.productId = productId
        }.build()

        val response = consentStub.revokeConsentForSubscription(request)
        if (response.statusCode != ErrorsProto.StatusCode.STATUS_CODE_OK) {
            throw RuntimeException(response.errorMessage)
        }
    }

}
