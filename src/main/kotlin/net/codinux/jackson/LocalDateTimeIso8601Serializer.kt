package net.codinux.jackson

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import kotlinx.datetime.LocalDateTime

class LocalDateTimeIso8601Serializer: JsonSerializer<LocalDateTime>() {

    override fun serialize(value: LocalDateTime, generator: JsonGenerator, serializers: SerializerProvider) {
        generator.writeString(value.toString())
    }

}