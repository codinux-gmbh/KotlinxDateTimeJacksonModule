package net.codinux.jackson

import kotlinx.datetime.Instant
import net.codinux.jackson.test.InstantWrapper
import net.codinux.jackson.test.JacksonObjectMapper
import kotlin.test.Test
import kotlin.test.assertEquals

class InstantIso8601SerializerTest {

    private val underTest = JacksonObjectMapper.mapperWithKotlinxDatetimeModule


    @Test
    fun serialize() {
        val isoString = "2015-10-21T18:17:13.948151Z"

        val result = underTest.writeValueAsString(InstantWrapper(Instant.parse(isoString)))

        assertEquals("""{"instant":"$isoString"}""", result)
    }

}