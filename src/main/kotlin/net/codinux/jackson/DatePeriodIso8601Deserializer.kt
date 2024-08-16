package net.codinux.jackson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import kotlinx.datetime.DatePeriod

class DatePeriodIso8601Deserializer : JsonDeserializer<DatePeriod>() {

    override fun deserialize(parser: JsonParser, context: DeserializationContext): DatePeriod =
        DatePeriod.parse(parser.text)

}