package com.github.danielfreitasbs.idempotency_receiver.service

import com.github.danielfreitasbs.idempotency_receiver.dto.LapTimeDTO
import com.github.danielfreitasbs.idempotency_receiver.mapper.LapTimeMapper
import java.util.UUID
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class LapTimeEventProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    @Value("\${spring.kafka.producer.template.default-topic:}") private val lapTimeCompletedTopic: String,
    private val lapTimeMapper: LapTimeMapper
) {
    fun produceEvent(event: LapTimeDTO) {
        println("sending event [$event] to topic $lapTimeCompletedTopic")
        this.kafkaTemplate.send("idempotency-topic", UUID.randomUUID().toString(), lapTimeMapper.mapLapToJson(event))
    }
}