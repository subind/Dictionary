package com.example.dictionary.feature_dictionary.data.remote.repository

import com.example.dictionary.feature_dictionary.data.remote.local.WordDb
import com.example.dictionary.feature_dictionary.data.remote.remote.NetworkService
import com.example.dictionary.feature_dictionary.domain.model.Word
import com.example.dictionary.feature_dictionary.domain.repository.RetrieveWord

class RetrieveWordImpl(
    private val api: NetworkService,
    private val db: WordDb
): RetrieveWord {

    override fun retrieveWord(wordToFetch: String): Word {
        return Word(mutableListOf(), mutableListOf(),"")
    }
}