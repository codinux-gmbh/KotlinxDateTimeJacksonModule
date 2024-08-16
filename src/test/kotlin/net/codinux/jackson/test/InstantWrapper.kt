package net.codinux.jackson.test

import kotlinx.datetime.Instant

class InstantWrapper(
    val instant: Instant? = null
) {
    override fun toString() = instant?.toString() ?: "null"
}