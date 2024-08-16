package net.codinux.jackson.test

import kotlinx.datetime.LocalTime

class LocalTimeWrapper(
    val time: LocalTime? = null
) {
    override fun toString() = time?.toString() ?: "null"
}