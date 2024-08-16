package net.codinux.jackson

import kotlinx.datetime.DatePeriod
import net.codinux.jackson.test.DatePeriodWrapper
import net.codinux.jackson.test.JacksonObjectMapper
import org.junit.jupiter.api.Test

class DatePeriodIso8601SerializerTest {

    private val underTest = JacksonObjectMapper.mapperWithKotlinxDateTimeModule


    @Test
    fun serialize() {
        val isoString = "P1Y2M4D"

        val result = underTest.writeValueAsString(DatePeriodWrapper(DatePeriod.parse(isoString)))

        kotlin.test.assertEquals("""{"datePeriod":"$isoString"}""", result)
    }

}