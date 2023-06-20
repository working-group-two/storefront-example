package com.wg2.storefront.consents

import com.wg2.storefront.GrpcShared
import com.wg2.storefront.PhoneNumber
import com.wgtwo.api.v0.common.ErrorsProto
import com.wgtwo.api.v0.consent.ConsentServiceGrpc
import com.wgtwo.api.v0.consent.ConsentsProto.CreateConsentForSubscriberRequest
import com.wgtwo.api.v0.consent.ConsentsProto.GetConsentsForSubscriberRequest
import com.wgtwo.api.v0.consent.ConsentsProto.RevokeConsentForSubscriberRequest
import org.slf4j.LoggerFactory

object ConsentService {
    private val logger by lazy { LoggerFactory.getLogger(javaClass) }
    private val consentStub = ConsentServiceGrpc.newBlockingStub(GrpcShared.channel).withInterceptors(GrpcShared.authInterceptor)

    fun getConsentsForSubscriber(phoneNumber: PhoneNumber): List<Consent> {
        val request = GetConsentsForSubscriberRequest.newBuilder().apply {
            this.phoneNumber = phoneNumber.toProto()
        }.build()

        val response = consentStub.getConsentsForSubscriber(request)

        return when (response.statusCode) {
            ErrorsProto.StatusCode.STATUS_CODE_OK -> response.consentsList.map { Consent.fromProto(it) }
            else -> throw  RuntimeException(response.errorMessage)
        }
    }

    fun createConsentForSubscriber(phoneNumber: PhoneNumber, productId: String, productVersion: String) {
        val request = CreateConsentForSubscriberRequest.newBuilder().apply {
            this.phoneNumber = phoneNumber.toProto()
            this.productId = productId
            this.productVersion = productVersion
         }.build()

         val response = consentStub.createConsentForSubscriber(request)
         if (response.statusCode != ErrorsProto.StatusCode.STATUS_CODE_OK) {
             throw RuntimeException(response.errorMessage)
         }
    }

    fun revokeConsentForSubscriber(phoneNumber: PhoneNumber, productId: String) {
        val request = RevokeConsentForSubscriberRequest.newBuilder().apply {
            this.phoneNumber = phoneNumber.toProto()
            this.productId = productId
        }.build()

        val response = consentStub.revokeConsentForSubscriber(request)
        if (response.statusCode != ErrorsProto.StatusCode.STATUS_CODE_OK) {
            throw RuntimeException(response.errorMessage)
        }
    }

}
