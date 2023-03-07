package dev.fidil.subscriptions.api

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

data class CreateSubscription(
    @TargetAggregateIdentifier
    val id: UUID,
    val ownerId: String,
    val type: SubscriptionType,
    val billingCycle: BillingCycle,
)

data class UpgradeSubscription(
    @TargetAggregateIdentifier
    val id: UUID,
    val ownerId: String,
    val type: SubscriptionType
)