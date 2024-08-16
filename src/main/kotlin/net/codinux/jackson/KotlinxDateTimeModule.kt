package net.codinux.jackson

import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.PackageVersion
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime

class KotlinxDateTimeModule : SimpleModule(KotlinxDateTimeModule::class.java.name, PackageVersion.VERSION) {

    init {
        addSerializer(Instant::class.java, InstantIso8601Serializer())
        addDeserializer(Instant::class.java, InstantIso8601Deserializer())

        addSerializer(LocalDateTime::class.java, LocalDateTimeIso8601Serializer())
        addDeserializer(LocalDateTime::class.java, LocalDateTimeIso8601Deserializer())

        addSerializer(LocalDate::class.java, LocalDateIso8601Serializer())
        addDeserializer(LocalDate::class.java, LocalDateIso8601Deserializer())

        addSerializer(LocalTime::class.java, LocalTimeIso8601Serializer())
        addDeserializer(LocalTime::class.java, LocalTimeIso8601Deserializer())
    }

}