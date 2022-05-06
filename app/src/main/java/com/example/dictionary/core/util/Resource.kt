package com.example.dictionary.core.util

sealed class Resource<T>(val data: T? = null, val message: String? = null, val isLoading: Boolean = false) {
    class Success<T>(data: T?): Resource<T>(data = data)
    class Error<T>(message: String?): Resource<T>(message = message)
    class Loading<T>(isLoading: Boolean = false): Resource<T>(isLoading = isLoading)
}