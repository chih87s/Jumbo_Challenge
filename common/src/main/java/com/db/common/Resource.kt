package com.db.common

import java.io.IOException

sealed class Resource<out R> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Failure(val error: Throwable) : Resource<Nothing>()

    companion object {
        fun <T> createError(
            error: Throwable,
        ): Resource<T> {
            return Failure(error)
        }

        fun <T> createSuccess(
            data: T,
        ): Resource<T> {
            return Success(data)
        }


    }

}

sealed class CustomException(message: String) : IOException(message)

data class NetworkException(
    val errorCode: Int? = null
) : CustomException("Network Error: ${errorCode ?: "Unknown"}")

data class ApiException(
    val apiUrl: String
) : CustomException("API Error at $apiUrl")

data class JsonParseException(
    val json: String
) : CustomException("JSON Parsing Error: Invalid JSON format for $json")