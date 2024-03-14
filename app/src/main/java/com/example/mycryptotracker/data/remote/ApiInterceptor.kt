package com.example.mycryptotracker.data.remote

import com.example.mycryptotracker.common.Constants
import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader(Constants.API_KEY_NAME, Constants.API_KEY_VALUE)
            .build()
        return chain.proceed(request)
    }
}