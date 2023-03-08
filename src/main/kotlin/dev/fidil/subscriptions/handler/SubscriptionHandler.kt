package dev.fidil.subscriptions.handler

import dev.fidil.subscriptions.api.SubscriptionCreated
import mu.KotlinLogging
import org.axonframework.config.ProcessingGroup
import org.axonframework.eventhandling.EventHandler
import org.springframework.stereotype.Component


@Component
@ProcessingGroup("subscriptions")
class SubscriptionHandler {

    private val logger = KotlinLogging.logger {}

    @EventHandler
    fun on(event: SubscriptionCreated) {
        logger.info { "received event: $event" }
    }
}