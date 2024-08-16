package net.codinux.jackson.test

import com.fasterxml.jackson.databind.ObjectMapper
import net.codinux.jackson.KotlinxDateTimeModule

object JacksonObjectMapper {

    val mapperWithKotlinxDateTimeModule: ObjectMapper = ObjectMapper().apply {
        registerModule(KotlinxDateTimeModule())
    }

}