package com.github.danielfreitasbs.idempotency_receiver.controller

import com.github.danielfreitasbs.idempotency_receiver.dto.LapTimeDTO
import com.github.danielfreitasbs.idempotency_receiver.service.LapTimeEventProducer
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LapTimeController(
    private val lapTimeService: LapTimeEventProducer
) {

    @PostMapping("/lap-time")
    fun postLapTime(@RequestBody lapTime: LapTimeDTO): ResponseEntity<String> {
        lapTimeService.produceEvent(lapTime)

        return ResponseEntity.ok().body("Lap time [${lapTime.id}] event produced")
    }
}