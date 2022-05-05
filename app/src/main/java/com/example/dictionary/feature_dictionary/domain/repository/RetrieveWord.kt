package com.example.dictionary.feature_dictionary.domain.repository

import com.example.dictionary.feature_dictionary.domain.model.Word

interface RetrieveWord {

    fun retrieveWord(word: String): Word

}