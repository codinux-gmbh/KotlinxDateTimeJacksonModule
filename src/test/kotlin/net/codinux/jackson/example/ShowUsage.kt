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
          "time" : "06:07:08.000000009",
          "dateTimePeriod" : "P1Y2M3DT4H5M6.000000007S",
          "datePeriod" : "P1Y2M3D"
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
            LocalTime(6, 7, 8, 9),
            DateTimePeriod(1, 2, 3, 4, 5, 6, 7),
            DatePeriod(1, 2, 3)
        )

        val json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(toSerialize)
        val equals = json == AllKotlinxDateTimeTypesSerialized
    }

}