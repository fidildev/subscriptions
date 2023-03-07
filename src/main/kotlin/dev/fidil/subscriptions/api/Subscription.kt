package dev.fidil.subscriptions.api

import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate
import java.util.*

@Aggregate
class Subscription {

    @AggregateIdentifier
    private lateinit var id: UUID
    private lateinit var ownerId: String
    private lateinit var type: SubscriptionType
    private lateinit var billingCycle: BillingCycle

    @CommandHandler
    fun constructor(command: CreateSubscription) {
        this.id = command.id
        AggregateLifecycle.apply(SubscriptionCreated(
            command.id,
            command.ownerId,
            command.type,
            command.billingCycle
        ))
    }

    @CommandHandler
    fun on(command: UpgradeSubscription) {
        if (this.type.ordinal <= command.type.ordinal) {
            throw RuntimeException("Cannot downgrade subscription with this method")
        }

        if (this.ownerId != command.ownerId) {
            throw RuntimeException("Cannot upgrade, not owner")
        }

        AggregateLifecycle.apply(SubscriptionUpdated(
            this.id,
            command.type
        ))
    }

    @EventSourcingHandler
    fun on(event: SubscriptionCreated) {
        this.type = event.type
        this.billingCycle = event.billingCycle
        this.ownerId = event.ownerId
    }

    @EventSourcingHandler
    fun on(event: SubscriptionUpdated) {
        this.type = event.type
    }
}