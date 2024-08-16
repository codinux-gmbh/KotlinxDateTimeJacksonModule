package net.codinux.jackson

import com.fasterxml.jackson.module.kotlin.readValue
import net.codinux.jackson.test.InstantWrapper
import net.codinux.jackson.test.JacksonObjectMapper
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class InstantIso8601DeserializerTest {

    private val underTest = JacksonObjectMapper.mapperWithKotlinxDateTimeModule


    @Test
    fun serialize() {
        val isoString = "2015-10-21T18:17:13.948151Z"

        val result = underTest.readValue<InstantWrapper>("""{"instant":"$isoString"}""")

        assertNotNull(result.instant)
        assertEquals(isoString, result.instant.toString())
    }

}