package com.boringapps.mysafety.utils

/**
 * Base interface for viewModel event classes in order to be scoped to [EventWrapper] using [wrap]
 */
interface BaseEvent

fun <EVENT : BaseEvent> EVENT.wrap() = EventWrapper(this)