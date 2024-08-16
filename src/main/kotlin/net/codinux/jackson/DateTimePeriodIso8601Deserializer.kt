package net.codinux.jackson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import kotlinx.datetime.DateTimePeriod

class DateTimePeriodIso8601Deserializer : JsonDeserializer<DateTimePeriod>() {

    override fun deserialize(parser: JsonParser, context: DeserializationContext): DateTimePeriod =
        DateTimePeriod.parse(parser.text)

}