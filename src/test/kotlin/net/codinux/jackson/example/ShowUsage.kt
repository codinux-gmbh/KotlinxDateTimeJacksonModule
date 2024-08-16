package net.codinux.jackson.example

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.datetime.*
import net.codinux.jackson.KotlinxDateTimeModule
import net.codinux.jackson.test.AllKotlinxDateTimeTypes

fun main() {
    ShowUsage().apply {
        deserializeKotlinxDateTimeTypes()
        serializeKotlinxDateTimeTypes()
    }
}


class ShowUsage {

    private val objectMapper = ObjectMapper().apply {
        registerModule(KotlinxDateTimeModule()) // that's all
    }

    // examples:

    private val AllKotlinxDateTimeTypesSerialized = """
        {
          "instant" : "2015-10-21T06:07:08.000000009Z",
          "dateTime" : "2015-10-21T06:07:08.000000009",
          "date" : "2015-10-21",
          "time" : "06:07:08.000000009"
        }
    """.trimIndent()

    fun deserializeKotlinxDateTimeTypes() {
        val deserialized = objectMapper.readValue<AllKotlinxDateTimeTypes>(AllKotlinxDateTimeTypesSerialized)
    }

    fun serializeKotlinxDateTimeTypes() {
        val toSerialize = AllKotlinxDateTimeTypes(
            Instant.parse("2015-10-21T06:07:08.000000009Z"),
            LocalDateTime(2015, 10, 21, 6, 7, 8, 9),
            LocalDate(2015, 10, 21),
            LocalTime(6, 7, 8, 9)
        )

        val json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(toSerialize)
        val equals = json == AllKotlinxDateTimeTypesSerialized
    }

}