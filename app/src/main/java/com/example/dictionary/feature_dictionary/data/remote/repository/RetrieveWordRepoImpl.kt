package com.example.dictionary.feature_dictionary.data.remote.repository

import com.example.dictionary.core.util.Resource
import com.example.dictionary.feature_dictionary.data.remote.local.WordDb
import com.example.dictionary.feature_dictionary.data.remote.remote.NetworkService
import com.example.dictionary.feature_dictionary.domain.model.Word
import com.example.dictionary.feature_dictionary.domain.repository.RetrieveWordRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Our approach is to store the data received from server in a local database & data to be displayed
 * in the UI will be fetched only from local db (SingleSourceOfTruth).
 */
class RetrieveWordRepoImpl
@Inject constructor(
    private val api: NetworkService,
    private val db: WordDb
): RetrieveWordRepo {

    private val dbOperations = db.wordDao()
    private lateinit var words: List<Word>

    override fun retrieveWord(wordToFetch: String): Flow<Resource<List<Word>>> {

        return flow {
            emit(Resource.Loading(true))

            words = dbOperations.fetchWord(wordToFetch).map { it.toWord() }
            if(words.isEmpty()) {
                try {
                    val wordEntity = api.getNetworkService().getWord(wordToFetch).map { it.toWordEntity() }
                    dbOperations.deleteWords(wordEntity.map { it.word })
                    dbOperations.insertWord(wordEntity)
                    words = dbOperations.fetchWord(wordToFetch).map { it.toWord() }
                }catch (e: Exception) {
                    emit(Resource.Error(e.toString()))
                }
            }
            emit(Resource.Success(words))
            emit(Resource.Loading(false))
        }
    }
}