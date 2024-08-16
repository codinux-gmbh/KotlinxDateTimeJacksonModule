package net.codinux.jackson

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import kotlinx.datetime.DateTimePeriod

class DateTimePeriodIso8601Serializer: JsonSerializer<DateTimePeriod>() {

    override fun serialize(value: DateTimePeriod, generator: JsonGenerator, serializers: SerializerProvider) {
        generator.writeString(value.toString())
    }

}