package net.codinux.jackson.test

import com.fasterxml.jackson.databind.ObjectMapper
import net.codinux.jackson.KotlinxDatetimeModule

object JacksonObjectMapper {

    val mapperWithKotlinxDatetimeModule: ObjectMapper = ObjectMapper().apply {
        registerModule(KotlinxDatetimeModule())
    }

}