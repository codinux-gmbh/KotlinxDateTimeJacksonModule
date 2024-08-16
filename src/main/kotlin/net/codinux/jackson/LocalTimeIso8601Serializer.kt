package net.codinux.jackson

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import kotlinx.datetime.LocalTime

class LocalTimeIso8601Serializer: JsonSerializer<LocalTime>() {

    override fun serialize(value: LocalTime, generator: JsonGenerator, serializers: SerializerProvider) {
        generator.writeString(value.toString())
    }

}