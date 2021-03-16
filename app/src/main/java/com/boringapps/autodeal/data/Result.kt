package com.boringapps.autodeal.data

import retrofit2.Response

sealed class Result<out T> {
    data class Success<out T>(val body: T?) : Result<T>()
    data class Failure<out T>(val code: Int, val message: String?) : Result<T>()

    fun isSuccessful() = this is Success

    suspend fun <R> letOnSuccess(action: suspend (T) -> R): R? {
        if (this is Success) {
            return body?.let {
                action(it)
            }
        }
        return null
    }

    companion object {

        fun <T> success(value: T?): Result<T> = Success(value)

        fun <T> failure(code: Int, message: String? = null): Result<T> = Failure(code, message)

        fun <T> emptySuccess(): Result<T> = Success(null)
    }
}

fun <T> Response<T>.convertToResult(): Result<T> {
    return when (code()) {
        SuccessCode.SUCCESS -> Result.success(body())
        else -> Result.failure(code(), message())
    }
}

object ErrorCodes {
    const val NETWORK_EXCEPTION = 408
    const val TIMEOUT = 400
    const val UNAUTHORIZED = 401
    const val LIMIT_REACHED = 403
    const val DUPLICATED_ITEM = 409
    const val SERVER_ERROR = 500
}

object SuccessCode {
    const val SUCCESS = 200
}
