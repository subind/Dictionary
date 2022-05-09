package com.example.dictionary.feature_dictionary.data.remote.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dictionary.feature_dictionary.data.remote.local.entities.WordEntity
import com.example.dictionary.feature_dictionary.data.util.Converters

@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class WordDb: RoomDatabase() {
    abstract fun wordDao(): WordDao
}