package com.github.danielfreitasbs.idempotency_receiver.mapper

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.danielfreitasbs.idempotency_receiver.dto.LapTimeDTO
import org.springframework.stereotype.Component

@Component
class LapTimeMapper {
    fun mapLapToJson(lapTime: LapTimeDTO): String {
        return ObjectMapper().writeValueAsString(lapTime)
    }
}