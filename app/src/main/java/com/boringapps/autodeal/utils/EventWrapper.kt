package com.boringapps.autodeal.utils

/**
 * Wraps an event from viewModels, so they are consumed only once.
 * What's different from SingleLiveEvent approach is that this can be observed in multiple places.
 */
open class EventWrapper<out T>(private val content: T) {

    private var consumed = false

    fun peek(): T = content

    fun consume(): T? {
        return if (consumed) {
            null
        } else {
            consumed = true
            content
        }
    }
}