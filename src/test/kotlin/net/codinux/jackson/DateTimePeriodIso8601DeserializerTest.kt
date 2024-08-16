package net.codinux.jackson

import com.fasterxml.jackson.module.kotlin.readValue
import net.codinux.jackson.test.DateTimePeriodWrapper
import net.codinux.jackson.test.JacksonObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class DateTimePeriodIso8601DeserializerTest {

    private val underTest = JacksonObjectMapper.mapperWithKotlinxDateTimeModule


    @Test
    fun deserialize() {
        val isoString = "P1Y2M4DT5H6M7.000000008S"

        val result = underTest.readValue<DateTimePeriodWrapper>("""{"dateTimePeriod":"$isoString"}""")

        assertNotNull(result.dateTimePeriod)
        assertEquals(isoString, result.dateTimePeriod.toString())
    }

}