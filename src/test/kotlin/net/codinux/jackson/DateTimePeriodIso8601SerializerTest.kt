package net.codinux.jackson

import kotlinx.datetime.DateTimePeriod
import net.codinux.jackson.test.DateTimePeriodWrapper
import net.codinux.jackson.test.JacksonObjectMapper
import org.junit.jupiter.api.Test

class DateTimePeriodIso8601SerializerTest {

    private val underTest = JacksonObjectMapper.mapperWithKotlinxDateTimeModule


    @Test
    fun serialize() {
        val isoString = "P1Y2M4DT5H6M7.000000008S"

        val result = underTest.writeValueAsString(DateTimePeriodWrapper(DateTimePeriod.parse(isoString)))

        kotlin.test.assertEquals("""{"dateTimePeriod":"$isoString"}""", result)
    }

}