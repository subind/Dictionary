package com.example.dictionary.feature_dictionary.domain.repository

import com.example.dictionary.core.util.Resource
import com.example.dictionary.feature_dictionary.domain.model.Word
import kotlinx.coroutines.flow.Flow

interface RetrieveWord {

    fun retrieveWord(word: String): Flow<Resource<List<Word>>>

}