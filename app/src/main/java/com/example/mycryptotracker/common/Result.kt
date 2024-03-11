package com.example.mycryptotracker.common

import java.lang.Exception

sealed class Result<T> {
    class Success<T>(val data: T?) : Result<T>()
    class Error<T>(val message: String? = null, val exception: Exception? = null) : Result<T>()
}