package net.codinux.jackson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import kotlinx.datetime.LocalTime

class LocalTimeIso8601Deserializer : JsonDeserializer<LocalTime>() {

    override fun deserialize(parser: JsonParser, context: DeserializationContext): LocalTime =
        LocalTime.parse(parser.text)

}