package com.wg2.storefront.sms

import com.wg2.storefront.GrpcShared
import com.wgtwo.api.v1.sms.SmsProto
import com.wgtwo.api.v1.sms.SmsServiceGrpc
import org.slf4j.LoggerFactory

object SmsService {

    private const val SENDER_NAME = "wotel"

    private val logger by lazy { LoggerFactory.getLogger(javaClass) }
    private val smsStub = SmsServiceGrpc.newBlockingStub(GrpcShared.channel).withInterceptors(GrpcShared.authInterceptor)

    fun sendToSubscriber(phoneNumber: String, content: String) {
        val request = SmsProto.SendTextToSubscriberRequest.newBuilder().apply {
            this.fromAddress = SENDER_NAME
            this.toSubscriber = getSanitizedPhoneNumber(phoneNumber)
            this.content = content
        }.build()

        val response = smsStub.sendTextToSubscriber(request)
        when (response.status) {
            SmsProto.SendMessageResponse.SendStatus.SEND_STATUS_OK -> return
            SmsProto.SendMessageResponse.SendStatus.SEND_STATUS_UNSPECIFIED,
            SmsProto.SendMessageResponse.SendStatus.SEND_STATUS_REJECT,
            SmsProto.SendMessageResponse.SendStatus.SEND_STATUS_ERROR,
            SmsProto.SendMessageResponse.SendStatus.UNRECOGNIZED -> throw RuntimeException(response.description)
            else -> throw RuntimeException(response.status.toString())
        }
    }

    private fun getSanitizedPhoneNumber(phoneNumber: String): String = phoneNumber.trim().let {
        if (!it.startsWith("+")) "+$it" else it
     }

}
