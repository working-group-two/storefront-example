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

    val onrelay = """
        {
          "targetUserType": "OPERATOR",
          "name": "OnRelay",
          "publicId": "onrelay",
          "version": 3,
          "id": 484,
          "snapshotId": 2911,
          "organizationId": 298,
          "submittedAt": 1683155170.502291,
          "acceptedAt": 1683184648.3010812,
          "updatedAt": 1683184648.40852,
          "deleted": null,
          "subtitle": "Mobile Branch Exchange",
          "description": "OnRelay is a powerful business phone system optimized for mobile users. OnRelay has enterprise grade features, requires no office infrastructure, and works anywhere there is a cell network.\n\nBusiness customers benefit from simple setup of advanced functionality to manage and distribute customer calls among their mobile workforce. Key features include auto-generated company voice menus, easily configurable auto-attendants, call queues with custom music on hold, dynamic call groups, working hours based routing logic, and flexible call destination rules.\n\nImportantly, OnRelay utilizes a unique integration between the business phone system and the mobile carrier infrastructure to bridge business phone systems with regular mobile telephony. By enabling the new OnRelay VPN feature for a company cellphone subscription, all calls involving the mobile number are managed by the business phone system and hence logged, managed, routed, integrated and recorded according to company policies, quality targets and CRM integrations.\n\nUnlike other cloud business phone systems, OnRelay uses standard cell minutes and regular smartphone call features - i.e. it is not a VoIP app. This means OnRelay does not drain cellular data packages and seamlessly integrate with standard phone call settings such as WiFi calling, dual SIM selections and roaming restrictions. Last, but not least, this architecture means professional users benefit from all the network upgrades and monitoring tools cell operators continuously improve to optimize coverage, capacity and voice quality for business phone calls on their network.  ",
          "iconImageId": 550,
          "bannerImageId": 652,
          "videoUrl": "https://youtu.be/E3Ko53YyEcw",
          "productUrl": "https://www.onrelay.com",
          "fullMarketAvailability": true,
          "subscriberSupportEmailOrUrl": "https://www.onrelay.com/contact-support/",
          "operatorSupportEmailOrUrl": "support@onrelay.net",
          "supportGuideUrl": "https://www.onrelay.com/troubleshooting/",
          "privacyStatementUrl": "https://www.onrelay.com/about/privacy-policy/",
          "storageAndProcessingCountries": "us",
          "additionalLegalAndPrivacyInfo": "https://www.onrelay.com/about/legal-notice/",
          "priceBundledUsd": "9.99",
          "preListed": false,
          "releaseNotes": "Updated scopes to reflect actual API integration",
          "submittedBy": "support@onrelay.net",
          "imageUuids": [
            "b47a6bb6-76f6-41a1-b8f0-afad389d3d2f",
            "55465f8c-064c-48db-8263-b4619622f301",
            "c83a505d-5947-4670-b56a-5664e59655ae",
            "2f6b5332-741f-4eab-8456-2182c3a51752",
            "194e1440-a3f5-4d1b-a8a3-af58dbf43c26",
            "b1cb585d-faf8-4248-b3fa-847f89844b97"
          ],
          "availableForTenantNames": [
            "loltel",
            "mobius",
            "google-fi-at",
            "arkessa",
            "holafly",
            "billion-connect",
            "telfoni",
            "esimgo",
            "erate",
            "genvoice",
            "wotel",
            "ckhiod-test-3uk",
            "ckhiod-test-3at",
            "wireless-logic",
            "telenor-connexion-se",
            "telenor-connexion-dk",
            "connexion",
            "redtea",
            "google-fi-uk"
          ],
          "categoryIds": [
            11,
            10
          ],
          "oauthClientIds": [
            "862055e7-55bc-4901-8b28-ea68eb34d326",
            "e4fc6abc-e2b6-4e97-888f-37bb2ddd6126"
          ],
          "sipIpsV4": [
            "23.236.54.251",
            "104.154.35.158"
          ],
          "databaseSmsSenderIds": [],
          "scopes": [
            "CALL_ROUTING_WRITE",
            "PHONE",
            "OPENID",
            "CALL_FORWARDING_DISABLE",
            "CALL_FORWARDING_SET_NUMBER",
            "CALL_FORWARDING_SET_VOICEMAIL",
            "SMS_TEXT_SEND_TO_SUBSCRIBER",
            "OFFLINE_ACCESS",
            "SMS_TEXT_SEND_FROM_SUBSCRIBER",
            "SUBSCRIPTION_HANDSET_DETAILS_READ",
            "SUBSCRIPTION_FIRST_ATTACHMENT_READ",
            "SUBSCRIPTION_COUNTRY_CHANGE_READ",
            "SUBSCRIPTION_PERIODIC_COUNTRY_READ"
          ],
          "organizationName": "OnRelay",
          "scopeValues": [
            "call.routing:write",
            "phone",
            "openid",
            "callforwarding.disable",
            "callforwarding.to_number",
            "callforwarding.to_voicemail",
            "sms.text:send_to_subscriber",
            "offline_access",
            "sms.text:send_from_subscriber",
            "subscription.handset_details:read",
            "subscription.first_attachment:read",
            "subscription.country_change:read",
            "subscription.periodic_country:read"
          ],
          "status": "LIVE"
        }
    """.trimIndent()

    val securityNotification = """
        {
          "targetUserType": "SUBSCRIBER",
          "name": "Security Notification",
          "publicId": "security-notification",
          "version": 3,
          "id": 171,
          "snapshotId": 4129,
          "organizationId": 9,
          "submittedAt": null,
          "acceptedAt": null,
          "updatedAt": 1685449846.930505,
          "deleted": null,
          "subtitle": "Get notified if your SIM is inserted into a device",
          "description": "Get a SMS when your SIM is used by a new device",
          "iconImageId": 196,
          "bannerImageId": 199,
          "videoUrl": null,
          "productUrl": "https://security-notification.dub.prod.wgtwo.com",
          "fullMarketAvailability": true,
          "subscriberSupportEmailOrUrl": "products@wgtwo.com",
          "operatorSupportEmailOrUrl": "products@wgtwo.com",
          "supportGuideUrl": null,
          "privacyStatementUrl": "https://wgtwo.com",
          "storageAndProcessingCountries": "ie",
          "additionalLegalAndPrivacyInfo": null,
          "priceBundledUsd": "0.00",
          "preListed": false,
          "releaseNotes": null,
          "submittedBy": null,
          "imageUuids": [
            "0f6e15cc-25e5-49ce-b24f-8f3f21572dd3",
            "58ea3c1d-8ea8-41d0-9d13-da18d7457fe9",
            "cb6a32d1-6db8-4eaa-ab7a-885c007c6250"
          ],
          "availableForTenantNames": [
            "connexion",
            "erate",
            "wotel"
          ],
          "categoryIds": [
            13
          ],
          "oauthClientIds": [
            "0136e037-bd29-4110-bb58-b0e4bdcca630",
            "f5b7490f-fc4b-4fdf-84e1-7cc9f56980fa"
          ],
          "sipIpsV4": [],
          "databaseSmsSenderIds": [
            {
              "id": "a11ecae2-5717-47cf-85d7-c44573a44f66",
              "tenantNames": [
                "erate",
                "wotel"
              ],
              "description": "The default sender ID isn't very nice.",
              "valueType": "ALPHANUMERIC",
              "value": "SecNotify",
              "createdAt": 1656578064.321762,
              "default": false
            }
          ],
          "scopes": [
            "PHONE",
            "SMS_TEXT_SEND_TO_SUBSCRIBER",
            "SUBSCRIPTION_HANDSET_DETAILS_READ",
            "CALL_FORWARDING_DISABLE",
            "CALL_FORWARDING_SET_NUMBER"
          ],
          "organizationName": "Working Group Two AS",
          "scopeValues": [
            "phone",
            "sms.text:send_to_subscriber",
            "subscription.handset_details:read",
            "callforwarding.disable",
            "callforwarding.to_number"
          ],
          "status": "DRAFT"
        }
    """.trimIndent()

    val spamAlert = """
        {
          "targetUserType": "OPERATOR",
          "name": "SMS Spam Alert",
          "publicId": "sms-spam-alert",
          "version": 3,
          "id": 459,
          "snapshotId": 1272,
          "organizationId": 9,
          "submittedAt": null,
          "acceptedAt": null,
          "updatedAt": 1674468803.840584,
          "deleted": null,
          "subtitle": "Alert the subscriber when they receive SMS spam",
          "description": "This product identifies text messages that may contain spam, phishing, dangerous URLs or spoofing, and sends the receiving subscriber a warning from the same number. \n\nThe warning is designed to help the subscriber avoid being taken advantage of, and says: \n⚠️ Spam alert\nThe previous message has been identified as potentially harmful.\nWe recommend that you do not answer, call back, or click any URL links in the previous text message. You should never give away sensitive information such as name, address, social security numbers, or bank details.\nBest regards, [your operator name]",
          "iconImageId": 518,
          "bannerImageId": 520,
          "videoUrl": null,
          "productUrl": "https://www.wgtwo.com/",
          "fullMarketAvailability": true,
          "subscriberSupportEmailOrUrl": "products@wgtwo.com",
          "operatorSupportEmailOrUrl": "products@wgtwo.com",
          "supportGuideUrl": "https://www.wgtwo.com/",
          "privacyStatementUrl": "https://www.wgtwo.com/privacy/",
          "storageAndProcessingCountries": "ie",
          "additionalLegalAndPrivacyInfo": null,
          "priceBundledUsd": "2.00",
          "preListed": false,
          "releaseNotes": null,
          "submittedBy": null,
          "imageUuids": [],
          "availableForTenantNames": [],
          "categoryIds": [
            10,
            13
          ],
          "oauthClientIds": [],
          "sipIpsV4": [],
          "databaseSmsSenderIds": [],
          "scopes": [],
          "organizationName": "Working Group Two AS",
          "scopeValues": [],
          "status": "DRAFT"
        }
    """.trimIndent()

    val voicebox = """
        {
          "targetUserType": "SUBSCRIBER",
          "name": "Voicebox",
          "publicId": "voicebox",
          "version": 4,
          "id": 25,
          "snapshotId": 4217,
          "organizationId": 9,
          "submittedAt": null,
          "acceptedAt": null,
          "updatedAt": 1685952583.216258,
          "deleted": null,
          "subtitle": "Unanswered calls as text and audio",
          "description": "This product lets you receive voicemails as MMS with audio and transcripts of what was said.",
          "iconImageId": 66,
          "bannerImageId": 106,
          "videoUrl": null,
          "productUrl": "https://voicebox.cc/login",
          "fullMarketAvailability": true,
          "subscriberSupportEmailOrUrl": "products@wgtwo.com",
          "operatorSupportEmailOrUrl": "products@wgtwo.com",
          "supportGuideUrl": "https://docs.google.com/presentation/d/1-hFilWWfWW0pLiBnQtq5wuLgcF8h3z59ajBF-NbpaGk/edit#slide=id.p",
          "privacyStatementUrl": "https://voicebox.cc/terms-and-conditions",
          "storageAndProcessingCountries": "ie",
          "additionalLegalAndPrivacyInfo": null,
          "priceBundledUsd": "0.00",
          "preListed": false,
          "releaseNotes": null,
          "submittedBy": null,
          "imageUuids": [
            "34c312ce-6397-4770-aaea-e779b9114cad"
          ],
          "availableForTenantNames": [
            "connexion",
            "erate",
            "wotel"
          ],
          "categoryIds": [
            10
          ],
          "oauthClientIds": [
            "adb4216e-e0f4-4cd6-94c4-2b0440e4b4fb"
          ],
          "sipIpsV4": [],
          "databaseSmsSenderIds": [
            {
              "id": "3277a869-bfd1-41d2-895f-455ebebe51bc",
              "tenantNames": [
                "wotel",
                "loltel",
                "erate"
              ],
              "description": "Sending from Voicebox",
              "valueType": "ALPHANUMERIC",
              "value": "Voicebox",
              "createdAt": 1683115563.5392523,
              "default": false
            }
          ],
          "scopes": [
            "CALL_FORWARDING_SET_VOICEMAIL",
            "EVENTS_VOICEMAIL_SUBSCRIBE",
            "MMS_SEND_TO_SUBSCRIBER",
            "OFFLINE_ACCESS",
            "OPENID",
            "PHONE",
            "SMS_SEND_TO_SUBSCRIBER",
            "VOICEMAIL_GET",
            "DATA_SET_CUSTOM_DNS",
            "SMS_TEXT_SEND_TO_SUBSCRIBER"
          ],
          "organizationName": "Working Group Two AS",
          "scopeValues": [
            "callforwarding.to_voicemail",
            "events.voicemail.subscribe",
            "mms.send.to_subscriber",
            "offline_access",
            "openid",
            "phone",
            "sms.send.to_subscriber",
            "voicemail.get",
            "data.set.dns",
            "sms.text:send_to_subscriber"
          ],
          "status": "DRAFT"
        }
    """.trimIndent()

    val webfilter = """
        {
          "targetUserType": "OPERATOR",
          "name": "Web Filtering for Kids",
          "publicId": "web-filtering-for-kids",
          "version": 1,
          "id": 421,
          "snapshotId": 1384,
          "organizationId": 9,
          "submittedAt": null,
          "acceptedAt": null,
          "updatedAt": 1675268778.508112,
          "deleted": null,
          "subtitle": "Filter out websites that contain harmful content",
          "description": "This product blocks sites which may contain content that are not fit for children. This includes websites that: \n\n- may contain sexually explicit content, images, or that are portrayed through visually expressive language.\n- sell, discuss, or glorify the consumption of various alcoholic and tobacco products, including beer, wine, and liquor.\n- serve static image, CSS, and JavaScript files.\n- serve files or host applications that force the web browser to mine cryptocurrency, often utilizing considerable system, network, and power resources.\n- attempt to trick the user into believing they are on a different site in order to gather information or for other purposes. Also includes sites with deceptive advertising practices such as performing click redirections without the users consent.\n- contain content whose main focus is on controlled substances, including the sale, discussion, or glorification of such substances. Does not include alcohol and tobacco as that has its own category.\n- allow a visitor to play games using wagers/placing bets, lottery pools, or provides information on such activities.\n- disseminate information, hold discussions, or provide a means to gain unauthorized or illegal access to computers and networks.\n- are primarily focused on promoting terrorism or hate.\n- focus on physical, mental, and social well-being, including fitness information, medical conditions, diagnosis, and medical services.\n- Illegal Content: Sites that focus on providing links to pirated movies, commercial software, or providing application keys and cracks for commercial applications.\n- are infected with or distribute any kind of malware, spyware, or viruses. Also contains sites acting as a C&C for bots, worms, trojans, and other malware.\n- allow visitors to upload content and share media such as photos and videos.\n- provide some type of a messaging or bulletin board system whose content is largely community generated.\n- are no longer controlled by the original owner or are being offered for sale. Content on these sites can often be misleading for non technical users.\n- focus is on connecting individuals for the purposes of dating.\n- provides information or a means to circumvent filtering proxies or detection systems, including VPN services and anonymous surfing\n- use various techniques to track user behavior across the internet.\n- primarily discuss, review, or sell items such as hunting knives, guns, rifles, or BB guns.",
          "iconImageId": 495,
          "bannerImageId": 486,
          "videoUrl": null,
          "productUrl": "https://wgtwo.com",
          "fullMarketAvailability": true,
          "subscriberSupportEmailOrUrl": "products@wgtwo.com",
          "operatorSupportEmailOrUrl": "products@wgtwo.com",
          "supportGuideUrl": "https://wgtwo.com",
          "privacyStatementUrl": "https://www.wgtwo.com/privacy/",
          "storageAndProcessingCountries": "ie",
          "additionalLegalAndPrivacyInfo": "This product does not store or process any user data. It filters by providing a \"content filter list\" to the WGTWO core network. ",
          "priceBundledUsd": "1.99",
          "preListed": false,
          "releaseNotes": null,
          "submittedBy": null,
          "imageUuids": [],
          "availableForTenantNames": [],
          "categoryIds": [
            12,
            13
          ],
          "oauthClientIds": [
            "262cd147-50f3-4ff6-818a-cdc2dcf0cb4d",
            "af88c17e-6b66-4799-81be-cd3ff22902f6"
          ],
          "sipIpsV4": [],
          "databaseSmsSenderIds": [],
          "scopes": [
            "DATA_CONTENT_FILTERING_READ",
            "DATA_CONTENT_FILTERING_WRITE",
            "OFFLINE_ACCESS",
            "OPENID",
            "PHONE",
            "SUBSCRIPTION_READ"
          ],
          "organizationName": "Working Group Two AS",
          "scopeValues": [
            "data.content_filtering:read",
            "data.content_filtering:write",
            "offline_access",
            "openid",
            "phone",
            "subscription.read"
          ],
          "status": "DRAFT"
        }
    """.trimIndent()

    val wgtgtp = """
        {
          "targetUserType": "OPERATOR",
          "name": "WG2 Support GTP",
          "publicId": "wg2-support-gtp",
          "version": 3,
          "id": 555,
          "snapshotId": 2382,
          "organizationId": 9,
          "submittedAt": null,
          "acceptedAt": null,
          "updatedAt": 1680084346.360491,
          "deleted": null,
          "subtitle": "Handles first line support 24/7 all year around",
          "description": "This product will be a cost saver on customer support for mobile phone operators, as well as increasing the support availability. \n\nYour customer can send any support request on SMS to a phone number set by you, and the AI will reply back on SMS to customer support questions. \n\nThe AI will be able to handle technical questions about phone settings quicker than a human, and can answer most questions about the service based on knowing what operator it’s replying on behalf of as well as knowing what subscriber asked. ",
          "iconImageId": 635,
          "bannerImageId": 636,
          "videoUrl": null,
          "productUrl": "https://www.wgtwo.com/",
          "fullMarketAvailability": false,
          "subscriberSupportEmailOrUrl": "products@wgtwo.com",
          "operatorSupportEmailOrUrl": "products@wgtwo.com",
          "supportGuideUrl": null,
          "privacyStatementUrl": "https://www.wgtwo.com/privacy/",
          "storageAndProcessingCountries": "us,ie",
          "additionalLegalAndPrivacyInfo": null,
          "priceBundledUsd": "0.01",
          "preListed": false,
          "releaseNotes": null,
          "submittedBy": null,
          "imageUuids": [],
          "availableForTenantNames": [],
          "categoryIds": [
            10,
            14,
            15
          ],
          "oauthClientIds": [],
          "sipIpsV4": [],
          "databaseSmsSenderIds": [],
          "scopes": [],
          "organizationName": "Working Group Two AS",
          "scopeValues": [],
          "status": "DRAFT"
        }
    """.trimIndent()

    val voxist = """
        {
          "targetUserType": "OPERATOR",
          "name": "Smart & Personalized Voicemail",
          "publicId": "smart-&-personalized-voicemail",
          "version": 1,
          "id": 344,
          "snapshotId": 4352,
          "organizationId": 150,
          "submittedAt": null,
          "acceptedAt": null,
          "updatedAt": 1686144079.786364,
          "deleted": null,
          "subtitle": "Read your voicemail and custom-greet your contacts",
          "description": "Voxist is an intelligent voicemail that replaces your carrier's inefficient voicemail. Delight callers with personalized greetings and save time by reading transcribed voicemail messages. Access messages on your phone or via email, so you never miss out.",
          "iconImageId": 527,
          "bannerImageId": 488,
          "videoUrl": "https://youtu.be/7VZYHb26ep0",
          "productUrl": "https://www.voxist.com",
          "fullMarketAvailability": true,
          "subscriberSupportEmailOrUrl": "support@voxist.com",
          "operatorSupportEmailOrUrl": "support+carrier@voxist.com",
          "supportGuideUrl": "https://www.voxist.com",
          "privacyStatementUrl": "https://www.iubenda.com/privacy-policy/63464178",
          "storageAndProcessingCountries": "fr,ie",
          "additionalLegalAndPrivacyInfo": "https://www.iubenda.com/terms-and-conditions/63464178",
          "priceBundledUsd": "0.00",
          "preListed": false,
          "releaseNotes": null,
          "submittedBy": null,
          "imageUuids": [
            "075c0c49-c0ba-4460-884a-b54dc810602c",
            "8ffc0a3e-3781-47a8-b023-2e505230966c",
            "b2589993-8cc9-4094-ab5a-a58d3ba2c86c",
            "cbd3ffa6-ba09-44b9-8f4c-5020c6d9a2f6"
          ],
          "availableForTenantNames": [
            "arkessa",
            "billion-connect",
            "erate",
            "esimgo",
            "holafly",
            "telfoni",
            "wotel"
          ],
          "categoryIds": [
            11,
            14
          ],
          "oauthClientIds": [],
          "sipIpsV4": [],
          "databaseSmsSenderIds": [
            {
              "id": "579331ad-0d00-48a0-99d9-2493242d8f16",
              "tenantNames": [
                "arkessa",
                "billion-connect",
                "ckhiod-test-3at",
                "ckhiod-test-3uk",
                "connexion",
                "erate",
                "esimgo",
                "genvoice",
                "google-fi-at",
                "google-fi-uk",
                "holafly",
                "mobius",
                "redtea",
                "telfoni",
                "wireless-logic",
                "wotel"
              ],
              "description": "To send OTP",
              "valueType": "ALPHANUMERIC",
              "value": "voxist",
              "createdAt": 1663840170.943607,
              "default": false
            }
          ],
          "scopes": [
            "CALL_FORWARDING_DISABLE",
            "CALL_FORWARDING_SET_NUMBER",
            "CALL_FORWARDING_SET_VOICEMAIL",
            "CALL_ROUTING_WRITE",
            "EVENTS_PERIODIC_COUNTRY_SUBSCRIBE",
            "EVENTS_COUNTRY_CHANGE_SUBSCRIBE",
            "EVENTS_VOICEMAIL_SUBSCRIBE",
            "EVENTS_VOICE_SUBSCRIBE",
            "OFFLINE_ACCESS",
            "PHONE",
            "VOICEMAIL_DELETE",
            "VOICEMAIL_GET",
            "VOICEMAIL_UPDATE",
            "SMS_SEND_TO_SUBSCRIBER",
            "SUBSCRIPTION_READ",
            "SUBSCRIPTION_WRITE",
            "SMS_TEXT_SEND_TO_SUBSCRIBER",
            "SMS_DATA_SEND_TO_SUBSCRIBER"
          ],
          "organizationName": "Voxist SAS",
          "scopeValues": [
            "callforwarding.disable",
            "callforwarding.to_number",
            "callforwarding.to_voicemail",
            "call.routing:write",
            "events.periodic_country.subscribe",
            "events.roaming.subscribe",
            "events.voicemail.subscribe",
            "events.voice.subscribe",
            "offline_access",
            "phone",
            "voicemail.delete",
            "voicemail.get",
            "voicemail.update",
            "sms.send.to_subscriber",
            "subscription.read",
            "subscription.write",
            "sms.text:send_to_subscriber",
            "sms.data:send_to_subscriber"
          ],
          "status": "DRAFT"
        }
    """.trimIndent()

    private val products = setOf(textRules, softphone, onrelay, securityNotification, spamAlert, voicebox, webfilter, wgtgtp, voxist)

    fun listProducts(): String = "[" + products.joinToString(",") + "]"
    fun getProduct(id: String): String? = products.find { it.contains(""""id": $id,""") }

}
