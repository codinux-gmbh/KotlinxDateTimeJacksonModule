package net.codinux.jackson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import kotlinx.datetime.Instant

class InstantIso8601Deserializer : JsonDeserializer<Instant>() {

    override fun deserialize(parser: JsonParser, context: DeserializationContext): Instant =
        Instant.parse(parser.text)

}