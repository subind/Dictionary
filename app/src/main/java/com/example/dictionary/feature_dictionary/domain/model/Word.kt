package com.example.dictionary.feature_dictionary.domain.model

data class Word(
    val word: String,
    val meanings: List<Meaning>
)
