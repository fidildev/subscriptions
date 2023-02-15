package dev.fidil.subscriptions.api

import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class RestEndpoint(private val commandGateway: CommandGateway) {

    @PostMapping("/", consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody createSubscription: CreateSubscription) {
        commandGateway.send<CreateSubscription>(createSubscription)
    }
}