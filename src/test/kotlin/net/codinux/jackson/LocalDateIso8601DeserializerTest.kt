package net.codinux.jackson

import com.fasterxml.jackson.module.kotlin.readValue
import net.codinux.jackson.test.JacksonObjectMapper
import net.codinux.jackson.test.LocalDateWrapper
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class LocalDateIso8601DeserializerTest {

    private val underTest = JacksonObjectMapper.mapperWithKotlinxDateTimeModule


    @Test
    fun deserialize() {
        val isoString = "2015-10-21"

        val result = underTest.readValue<LocalDateWrapper>("""{"date":"$isoString"}""")

        assertNotNull(result.date)
        assertEquals(isoString, result.date.toString())
    }

}