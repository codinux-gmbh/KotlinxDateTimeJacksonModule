package net.codinux.jackson

import kotlinx.datetime.LocalTime
import net.codinux.jackson.test.JacksonObjectMapper
import net.codinux.jackson.test.LocalTimeWrapper
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalTimeIso8601SerializerTest {

    private val underTest = JacksonObjectMapper.mapperWithKotlinxDatetimeModule


    @Test
    fun serialize() {
        val isoString = "18:17:13"

        val result = underTest.writeValueAsString(LocalTimeWrapper(LocalTime.parse(isoString)))

        assertEquals("""{"time":"$isoString"}""", result)
    }

}