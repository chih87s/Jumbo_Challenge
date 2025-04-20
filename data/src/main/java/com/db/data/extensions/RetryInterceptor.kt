package com.db.data.extensions

import com.db.common.constants.ApiConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class RetryInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var attempt = 0

        var lastException: IOException? = null

        while (attempt < ApiConfig.MAX_RETRY_COUNT) {
            try {
                return chain.proceed(chain.request())
            } catch (e: IOException) {
                attempt++
                lastException = e
                Thread.sleep(1000)
            }
        }

        throw lastException ?: IOException("Unknown IO error")

    }

}