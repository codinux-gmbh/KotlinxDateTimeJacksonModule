package net.codinux.jackson.test

import kotlinx.datetime.DatePeriod

class DatePeriodWrapper(
    val datePeriod: DatePeriod? = null
) {
    override fun toString() = datePeriod?.toString() ?: "null"
}