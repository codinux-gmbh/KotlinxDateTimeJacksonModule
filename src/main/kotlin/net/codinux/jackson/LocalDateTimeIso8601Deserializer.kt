package net.codinux.jackson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import kotlinx.datetime.LocalDateTime

class LocalDateTimeIso8601Deserializer : JsonDeserializer<LocalDateTime>() {

    override fun deserialize(parser: JsonParser, context: DeserializationContext): LocalDateTime =
        LocalDateTime.parse(parser.text)

}