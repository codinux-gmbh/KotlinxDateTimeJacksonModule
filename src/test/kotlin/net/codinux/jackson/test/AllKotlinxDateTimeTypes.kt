package net.codinux.jackson.test

import kotlinx.datetime.*

class AllKotlinxDateTimeTypes(
    val instant: Instant? = null,
    val dateTime: LocalDateTime? = null,
    val date: LocalDate? = null,
    val time: LocalTime? = null,
    val dateTimePeriod: DateTimePeriod? = null,
    val datePeriod: DatePeriod? = null
)