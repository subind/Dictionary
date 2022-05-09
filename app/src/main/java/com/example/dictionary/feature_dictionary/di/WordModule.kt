package com.example.dictionary.feature_dictionary.di

import android.app.Application
import androidx.room.Room
import com.example.dictionary.feature_dictionary.data.remote.local.WordDb
import com.example.dictionary.feature_dictionary.data.remote.remote.NetworkService
import com.example.dictionary.feature_dictionary.data.remote.remote.RetrofitServiceImpl
import com.example.dictionary.feature_dictionary.data.remote.repository.RetrieveWordRepoImpl
import com.example.dictionary.feature_dictionary.data.util.Converters
import com.example.dictionary.feature_dictionary.data.util.GsonParser
import com.example.dictionary.feature_dictionary.data.util.JsonParser
import com.example.dictionary.feature_dictionary.domain.repository.RetrieveWordRepo
import com.example.dictionary.feature_dictionary.domain.use_case.FetchWord
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordModule {

    @Provides
    @Singleton
    fun provideFetchWordUseCase(retrieveWordRepo: RetrieveWordRepo): FetchWord {
        return FetchWord(retrieveWordRepo)
    }

    @Provides
    @Singleton
    fun provideRetrieveWordRepository(api: NetworkService, db: WordDb): RetrieveWordRepo {
        return RetrieveWordRepoImpl(api, db)
    }

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService {
        return RetrofitServiceImpl()
    }

    @Provides
    @Singleton
    fun provideWordDatabase(app: Application, jsonParser: JsonParser): WordDb {
        return Room.databaseBuilder(
            app,
            WordDb::class.java,
            "word_db"
        )
            .addTypeConverter(Converters(jsonParser))
            .build()
    }

    @Provides
    @Singleton
    fun provideGsonParserImpl(): JsonParser {
        return GsonParser(Gson())
    }


}