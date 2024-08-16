package net.codinux.jackson.test

import kotlinx.datetime.LocalDate

class LocalDateWrapper(
    val date: LocalDate? = null
) {
    override fun toString() = date?.toString() ?: "null"
}