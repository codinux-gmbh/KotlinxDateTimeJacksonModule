package net.codinux.jackson

import com.fasterxml.jackson.databind.module.SimpleModule
import kotlinx.datetime.*

class KotlinxDateTimeModule : SimpleModule(KotlinxDateTimeModule::class.java.name, PackageVersion.Version) {

    init {
        addSerializer(Instant::class.java, InstantIso8601Serializer())
        addDeserializer(Instant::class.java, InstantIso8601Deserializer())

        addSerializer(LocalDateTime::class.java, LocalDateTimeIso8601Serializer())
        addDeserializer(LocalDateTime::class.java, LocalDateTimeIso8601Deserializer())

        addSerializer(LocalDate::class.java, LocalDateIso8601Serializer())
        addDeserializer(LocalDate::class.java, LocalDateIso8601Deserializer())

        addSerializer(LocalTime::class.java, LocalTimeIso8601Serializer())
        addDeserializer(LocalTime::class.java, LocalTimeIso8601Deserializer())

        addSerializer(DateTimePeriod::class.java, DateTimePeriodIso8601Serializer())
        addDeserializer(DateTimePeriod::class.java, DateTimePeriodIso8601Deserializer())

        addSerializer(DatePeriod::class.java, DatePeriodIso8601Serializer())
        addDeserializer(DatePeriod::class.java, DatePeriodIso8601Deserializer())
    }

}