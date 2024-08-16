package net.codinux.jackson

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import kotlinx.datetime.Instant

class InstantIso8601Serializer: JsonSerializer<Instant>() {

    override fun serialize(value: Instant, generator: JsonGenerator, serializers: SerializerProvider) {
        generator.writeString(value.toString())
    }

}