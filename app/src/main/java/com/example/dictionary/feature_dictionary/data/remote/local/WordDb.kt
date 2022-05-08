package com.example.dictionary.feature_dictionary.data.remote.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dictionary.feature_dictionary.data.remote.local.entities.WordEntity

@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
abstract class WordDb: RoomDatabase() {
    abstract fun wordDao(): WordDao
}