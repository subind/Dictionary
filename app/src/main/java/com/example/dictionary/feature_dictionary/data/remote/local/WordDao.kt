package com.example.dictionary.feature_dictionary.data.remote.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dictionary.feature_dictionary.data.remote.local.entities.WordEntity

@Dao
interface WordDao {

    //The reason the param is a list is because the server returns a list of word objects
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: List<WordEntity>)

    @Query("SELECT * FROM WordEntity WHERE word LIKE '%' || :word || '%'")
    suspend fun fetchWord(word: String): List<WordEntity>

    @Query("DELETE FROM WordEntity WHERE word IN(:words)")
    suspend fun deleteWords(words: List<String>)

}
