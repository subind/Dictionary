package com.example.dictionary.feature_dictionary.domain.use_case

import com.example.dictionary.core.util.Resource
import com.example.dictionary.feature_dictionary.domain.model.Word
import com.example.dictionary.feature_dictionary.domain.repository.RetrieveWordRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FetchWord(private val retrieveWordRepo: RetrieveWordRepo) {

    fun fetch(word: String): Flow<Resource<List<Word>>> {
        if (word.isNotBlank()) {
            return retrieveWordRepo.retrieveWord(word)
        }
        return flow { }
    }

}