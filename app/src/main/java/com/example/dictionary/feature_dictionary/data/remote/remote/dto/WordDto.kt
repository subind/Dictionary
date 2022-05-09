package com.example.dictionary.feature_dictionary.data.remote.remote.dto

import com.example.dictionary.feature_dictionary.data.remote.local.entities.WordEntity

data class WordDto(
    val license: LicenseDto,
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val sourceUrls: List<String>,
    val word: String
) {
    fun toWordEntity(): WordEntity {
        return WordEntity(
            word = word,
            meanings = meanings.map { it.toMeaning() }
        )
    }
}