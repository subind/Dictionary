package com.example.dictionary.feature_dictionary.data.remote.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionary.feature_dictionary.domain.model.Meaning
import com.example.dictionary.feature_dictionary.domain.model.Word

@Entity
data class WordEntity(
    val word: String?,
    val meanings: List<Meaning>?,
    @PrimaryKey
    val id: Int? = null
) {
    fun toWord(): Word {
        return Word(
            word = word,
            meanings = meanings
        )
    }
}
