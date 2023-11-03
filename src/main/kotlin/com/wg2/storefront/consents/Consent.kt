package com.wg2.storefront.consents

import com.wgtwo.api.v0.consent.ConsentsProto
import java.lang.RuntimeException

interface Consent {

    companion object {
        fun fromProto(consent: ConsentsProto.Consent): Consent = when (consent.owner.valueCase) {
            ConsentsProto.ConsentOwner.ValueCase.SUBSCRIPTION -> SubscriberConsent(
                productId = consent.productId,
                subscriptionId = consent.owner.subscription.subscriptionIdentifier.value,
                scopes = consent.scopesList.map { it.property },
                revokable = consent.revokable,
            )
            ConsentsProto.ConsentOwner.ValueCase.TENANT -> TenantConsent(
                productId = consent.productId,
                tenant = consent.owner.tenant.name,
                scopes = consent.scopesList.map { it.property },
                revokable = consent.revokable,
            )
            else -> throw RuntimeException("Unknown consent type")
        }
    }

}

data class SubscriberConsent(
    val productId: String,
    val subscriptionId: String,
    val scopes: List<String>,
    val revokable: Boolean,
) : Consent

data class TenantConsent(
    val productId: String,
    val tenant: String,
    val scopes: List<String>,
    val revokable: Boolean,
) : Consent
