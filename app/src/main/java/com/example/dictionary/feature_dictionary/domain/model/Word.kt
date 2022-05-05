package com.example.dictionary.feature_dictionary.domain.model

data class Word(
    val meanings: List<Meaning>,
    val sourceUrls: List<String>,
    val word: String
)
