package com.example.dictionary.feature_dictionary.data.remote.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dictionary.feature_dictionary.data.remote.local.entities.WordEntity

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWord(word: WordEntity)

    @Query("SELECT * FROM WordEntity")
    fun fetchWord(): WordEntity

}
