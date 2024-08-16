package net.codinux.jackson

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import kotlinx.datetime.DatePeriod

class DatePeriodIso8601Serializer: JsonSerializer<DatePeriod>() {

    override fun serialize(value: DatePeriod, generator: JsonGenerator, serializers: SerializerProvider) {
        generator.writeString(value.toString())
    }

}