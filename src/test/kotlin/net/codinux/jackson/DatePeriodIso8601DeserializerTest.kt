package net.codinux.jackson

import com.fasterxml.jackson.module.kotlin.readValue
import net.codinux.jackson.test.DatePeriodWrapper
import net.codinux.jackson.test.JacksonObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class DatePeriodIso8601DeserializerTest {

    private val underTest = JacksonObjectMapper.mapperWithKotlinxDateTimeModule


    @Test
    fun deserialize() {
        val isoString = "P1Y2M4D"

        val result = underTest.readValue<DatePeriodWrapper>("""{"datePeriod":"$isoString"}""")

        assertNotNull(result.datePeriod)
        assertEquals(isoString, result.datePeriod.toString())
    }

}