package dev.fidil.subscriptions.api

import java.util.UUID

data class SubscriptionCreated(
    val id: UUID,
    val ownerId: String,
    val type: SubscriptionType,
    val billingCycle: BillingCycle
)

data class SubscriptionUpdated(
    val id: UUID,
    val type: SubscriptionType
)