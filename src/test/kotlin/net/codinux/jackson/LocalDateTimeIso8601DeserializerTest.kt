package net.codinux.jackson

import com.fasterxml.jackson.module.kotlin.readValue
import net.codinux.jackson.test.JacksonObjectMapper
import net.codinux.jackson.test.LocalDateTimeWrapper
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class LocalDateTimeIso8601DeserializerTest {

    private val underTest = JacksonObjectMapper.mapperWithKotlinxDatetimeModule


    @Test
    fun serialize() {
        val isoString = "2015-10-21T18:17:13"

        val result = underTest.readValue<LocalDateTimeWrapper>("""{"dateTime":"$isoString"}""")

        assertNotNull(result.dateTime)
        assertEquals(isoString, result.dateTime.toString())
    }

}