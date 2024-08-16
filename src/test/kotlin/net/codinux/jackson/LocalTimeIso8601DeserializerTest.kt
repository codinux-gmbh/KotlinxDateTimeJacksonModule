package net.codinux.jackson

import com.fasterxml.jackson.module.kotlin.readValue
import net.codinux.jackson.test.JacksonObjectMapper
import net.codinux.jackson.test.LocalTimeWrapper
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class LocalTimeIso8601DeserializerTest {

    private val underTest = JacksonObjectMapper.mapperWithKotlinxDateTimeModule


    @Test
    fun serialize() {
        val isoString = "18:17:13"

        val result = underTest.readValue<LocalTimeWrapper>("""{"time":"$isoString"}""")

        assertNotNull(result.time)
        assertEquals(isoString, result.time.toString())
    }

}