package net.codinux.jackson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import kotlinx.datetime.LocalDate

class LocalDateIso8601Deserializer : JsonDeserializer<LocalDate>() {

    override fun deserialize(parser: JsonParser, context: DeserializationContext): LocalDate =
        LocalDate.parse(parser.text)

}