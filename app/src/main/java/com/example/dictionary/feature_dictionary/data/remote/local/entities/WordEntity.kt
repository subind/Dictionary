package com.example.dictionary.feature_dictionary.data.remote.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WordEntity(
    val word: String,
    val audio: String?,
    val sourceUrl: String?,
    @PrimaryKey
    val id: Int
)
