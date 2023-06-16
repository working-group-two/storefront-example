package com.wg2.storefront.products

object ProductService {

    val textRules = """
        {
          "targetUserType": "SUBSCRIBER",
          "name": "Textrules",
          "publicId": "textrules",
          "version": 6,
          "id": 78,
          "snapshotId": 4213,
          "organizationId": 9,
          "submittedAt": null,
          "acceptedAt": null,
          "updatedAt": 1685951990.548124,
          "deleted": null,
          "subtitle": "Rules to forward your SMS",
          "description": "Textrules allows you to set rules for forwarding SMS to other phone numbers, email, and Slack.",
          "iconImageId": 125,
          "bannerImageId": 164,
          "videoUrl": null,
          "productUrl": "https://textrules.cc/start-login?iframe",
          "fullMarketAvailability": false,
          "subscriberSupportEmailOrUrl": " products@wgtwo.com",
          "operatorSupportEmailOrUrl": "products@wgtwo.com",
          "supportGuideUrl": "https://textrules.cc/start-login?iframe",
          "privacyStatementUrl": "https://textrules.cc/terms-and-conditions",
          "storageAndProcessingCountries": "ie",
          "additionalLegalAndPrivacyInfo": null,
          "priceBundledUsd": "0.00",
          "preListed": false,
          "releaseNotes": null,
          "submittedBy": null,
          "imageUuids": [
            "2622217e-caf9-4d98-966c-997f611bafa3",
            "394a0579-6cb3-427e-95ee-fd24b70eadbc",
            "4e6acef8-4c18-4316-9366-c976f6f0ca73",
            "a3d8eabb-e782-4ba8-a2b5-9a2964b5eda1",
            "c783ada3-af11-40b1-824f-212565420aae"
          ],
          "availableForTenantNames": [
            "connexion",
            "erate",
            "telfoni",
            "wotel"
          ],
          "categoryIds": [
            10,
            14,
            15
          ],
          "oauthClientIds": [
            "cfc42e9a-c378-4892-b18e-4d5e0df81847"
          ],
          "sipIpsV4": [],
          "databaseSmsSenderIds": [
            {
              "id": "ec7f3713-a329-45a6-b01d-54badf97c4f6",
              "tenantNames": [
                "erate"
              ],
              "description": "Testing sms sender id and versions",
              "valueType": "ALPHANUMERIC",
              "value": "Texty",
              "createdAt": 1674117037.7553794,
              "default": false
            }
          ],
          "scopes": [
            "EVENTS_SMS_SUBSCRIBE",
            "OFFLINE_ACCESS",
            "OPENID",
            "PHONE",
            "SMS_SEND_FROM_SUBSCRIBER",
            "SMS_TEXT_SEND_FROM_SUBSCRIBER",
            "SMS_TEXT_SEND_TO_SUBSCRIBER"
          ],
          "organizationName": "Working Group Two AS",
          "scopeValues": [
            "events.sms.subscribe",
            "offline_access",
            "openid",
            "phone",
            "sms.send.from_subscriber",
            "sms.text:send_from_subscriber",
            "sms.text:send_to_subscriber"
          ],
          "status": "DRAFT"
        }
    """.trimIndent()

    val softphone = """
        {
          "targetUserType": "SUBSCRIBER",
          "name": "Softphone",
          "publicId": "softphone",
          "version": 2,
          "id": 173,
          "snapshotId": 1466,
          "organizationId": 9,
          "submittedAt": null,
          "acceptedAt": null,
          "updatedAt": 1675931966.85452,
          "deleted": null,
          "subtitle": "A web-based phone client.",
          "description": "Make outgoing calls from your browser. Answer incoming calls, transfer ongoing calls.",
          "iconImageId": 200,
          "bannerImageId": 201,
          "videoUrl": null,
          "productUrl": "https://softphone.dub.prod.wgtwo.com",
          "fullMarketAvailability": false,
          "subscriberSupportEmailOrUrl": "products@wgtwo.com",
          "operatorSupportEmailOrUrl": "products@wgtwo.com",
          "supportGuideUrl": null,
          "privacyStatementUrl": "https://softphone.dub.prod.wgtwo.com/terms-and-conditions",
          "storageAndProcessingCountries": "ie",
          "additionalLegalAndPrivacyInfo": null,
          "priceBundledUsd": "0.00",
          "preListed": false,
          "releaseNotes": null,
          "submittedBy": null,
          "imageUuids": [
            "2f4a2b2a-051c-4c8a-a7ce-0a2b2025e2e1",
            "a35353bf-c92a-432c-b794-2b5d2932f675",
            "a65f2150-d4ff-4b43-9705-0143b79741db"
          ],
          "availableForTenantNames": [
            "connexion",
            "erate",
            "wotel"
          ],
          "categoryIds": [
            11
          ],
          "oauthClientIds": [
            "0610ad9a-ec40-4103-9dcb-021cd05a4faa"
          ],
          "sipIpsV4": [],
          "databaseSmsSenderIds": [
            {
              "id": "b69c1030-6f12-49a0-926e-968a31e71112",
              "tenantNames": [
                "billion-connect",
                "telfoni"
              ],
              "description": "Test",
              "valueType": "ALPHANUMERIC",
              "value": "Test",
              "createdAt": 1646842071.506151,
              "default": false
            },
            {
              "id": "8a5fdb41-8d33-457f-9fde-eed4a2a9f7ba",
              "tenantNames": [
                "wotel",
                "loltel",
                "erate"
              ],
              "description": "Testing new softphone sender id",
              "valueType": "ALPHANUMERIC",
              "value": "Softphone",
              "createdAt": 1674039225.157174,
              "default": false
            }
          ],
          "scopes": [
            "CALL_CONTROL_ANSWER_AND_INITIATE",
            "OFFLINE_ACCESS",
            "OPENID",
            "PHONE"
          ],
          "organizationName": "Working Group Two AS",
          "scopeValues": [
            "call.control.answer_and_initiate",
            "offline_access",
            "openid",
            "phone"
          ],
          "status": "DRAFT"
        }
    """.trimIndent()

    private val products = setOf(textRules, softphone)

    fun listProducts(): String = "[" + products.joinToString(",") + "]"
    fun getProduct(id: String): String? = products.find { it.contains(""""id": $id,""") }

}
