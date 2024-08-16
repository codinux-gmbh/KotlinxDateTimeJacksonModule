package net.codinux.jackson

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import kotlinx.datetime.LocalDate

class LocalDateIso8601Serializer: JsonSerializer<LocalDate>() {

    override fun serialize(value: LocalDate, generator: JsonGenerator, serializers: SerializerProvider) {
        generator.writeString(value.toString())
    }

}