package com.boringapps.autodeal.utils

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <T> LiveData<T>.observeNonNull(lifecycleOwner: LifecycleOwner, crossinline observer: (T) -> Unit) {
    this.observe(lifecycleOwner, Observer { data ->
        data?.let { observer(it) }
    })
}

inline fun <T : ViewDataBinding> T.executeAfter(block: T.() -> Unit) {
    block()
    executePendingBindings()
}