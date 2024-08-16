package net.codinux.jackson

import kotlinx.datetime.LocalDate
import net.codinux.jackson.test.JacksonObjectMapper
import net.codinux.jackson.test.LocalDateWrapper
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalDateIso8601SerializerTest {

    private val underTest = JacksonObjectMapper.mapperWithKotlinxDatetimeModule


    @Test
    fun serialize() {
        val isoString = "2015-10-21"

        val result = underTest.writeValueAsString(LocalDateWrapper(LocalDate.parse(isoString)))

        assertEquals("""{"date":"$isoString"}""", result)
    }

}