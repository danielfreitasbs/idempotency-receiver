package com.github.danielfreitasbs.idempotency_receiver.dto

data class LapTimeDTO(
    val id: String,
    val lapTime: Long,
    val car: String,
    val driver: String,
    val lap: Int
)