package com.github.danielfreitasbs.idempotency_receiver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IdempotencyReceiverApplication

fun main(args: Array<String>) {
	runApplication<IdempotencyReceiverApplication>(*args)
}
