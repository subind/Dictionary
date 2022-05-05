package com.example.dictionary.feature_dictionary.data.remote.remote.dto

import com.example.dictionary.feature_dictionary.domain.model.Word

data class WordDto(
    val license: LicenseDto,
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val sourceUrls: List<String>,
    val word: String
) {
    fun toWord(): Word {
        return Word(
            meanings = meanings.map { it.toMeaning() },
            sourceUrls = sourceUrls,
            word = word
        )
    }
}