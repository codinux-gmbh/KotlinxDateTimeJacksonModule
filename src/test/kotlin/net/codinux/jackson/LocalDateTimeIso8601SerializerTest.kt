package net.codinux.jackson

import kotlinx.datetime.LocalDateTime
import net.codinux.jackson.test.JacksonObjectMapper
import net.codinux.jackson.test.LocalDateTimeWrapper
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalDateTimeIso8601SerializerTest {

    private val underTest = JacksonObjectMapper.mapperWithKotlinxDateTimeModule


    @Test
    fun serialize() {
        val isoString = "2015-10-21T18:17:13"

        val result = underTest.writeValueAsString(LocalDateTimeWrapper(LocalDateTime.parse(isoString)))

        assertEquals("""{"dateTime":"$isoString"}""", result)
    }

}