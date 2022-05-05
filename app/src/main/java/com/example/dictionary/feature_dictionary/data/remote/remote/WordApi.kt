package com.example.dictionary.feature_dictionary.data.remote.remote

import com.example.dictionary.feature_dictionary.data.remote.remote.dto.WordDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WordApi {

    @GET("api/v2/entries/en/{word}")
    fun getWord(@Path("word") word: String): Response<WordDto>

}