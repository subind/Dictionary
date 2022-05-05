package com.example.dictionary.feature_dictionary.data.remote.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServiceImpl : NetworkService {

    override fun getNetworkService(): WordApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WordApi::class.java)
    }

    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev/"
    }

}