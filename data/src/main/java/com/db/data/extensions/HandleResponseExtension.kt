package com.db.data.extensions

import com.db.common.ApiException
import com.db.common.JsonParseException
import com.db.common.NetworkException
import com.db.common.Resource
import com.db.common.model.ResponseModel
import com.google.gson.JsonSyntaxException
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.UnknownHostException


suspend fun <T : ResponseModel> handleAPICall(
    apiCall: suspend () -> Response<T>
): Resource<T> {
    return try {
        apiCall.invoke().handleAPIResponse()
    } catch (e: Exception) {
        mapErrorToResource(e)
    }
}

private fun <T : ResponseModel> Response<T>.handleAPIResponse(): Resource<T> {
    return if (isSuccess()) {
        body()?.let {
            Resource.createSuccess(it)
        } ?: Resource.createError(ApiException("API Error: No content"))
    } else {
        Resource.createError(ApiException("API Error: ${message()}"))
    }
}

private fun mapErrorToResource(e: Exception): Resource<Nothing> {
    return when (e) {
        is UnknownHostException -> Resource.createError(NetworkException())
        is HttpException -> mapHttpExceptionToResource(e)
        is JsonSyntaxException -> Resource.createError(JsonParseException("Invalid JSON format"))
        else -> Resource.createError(IOException("Unknown Error"))
    }
}

private fun mapHttpExceptionToResource(e: HttpException): Resource<Nothing> {
    return when (e.code()) {
        400 -> Resource.createError(ApiException("Bad Request: ${e.message()}"))
        401 -> Resource.createError(ApiException("Unauthorized: ${e.message()}"))
        404 -> Resource.createError(ApiException("Not Found: ${e.message()}"))
        500 -> Resource.createError(ApiException("Internal Server Error: ${e.message()}"))
        else -> Resource.createError(ApiException("API Error: ${e.message()}"))
    }
}


private fun <T : ResponseModel> Response<T>.isSuccess(): Boolean = isSuccessful
