package net.codinux.jackson.test

import kotlinx.datetime.DateTimePeriod

class DateTimePeriodWrapper(
    val dateTimePeriod: DateTimePeriod? = null
) {
    override fun toString() = dateTimePeriod?.toString() ?: "null"
}