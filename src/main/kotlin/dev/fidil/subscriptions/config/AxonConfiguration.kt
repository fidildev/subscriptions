package dev.fidil.subscriptions.config

import org.axonframework.eventhandling.tokenstore.TokenStore
import org.axonframework.eventhandling.tokenstore.jpa.JpaTokenStore
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


//@Configuration
class AxonConfiguration {
    @Bean
    fun jpaTokenStore(): TokenStore {
        return JpaTokenStore.builder()
            .build()
    }
}