package net.codinux.jackson.test

import kotlinx.datetime.LocalDateTime

class LocalDateTimeWrapper(
    val dateTime: LocalDateTime? = null
) {
    override fun toString() = dateTime?.toString() ?: "null"
}