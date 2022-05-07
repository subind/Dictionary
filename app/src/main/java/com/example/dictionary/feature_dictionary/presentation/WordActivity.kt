package com.example.dictionary.feature_dictionary.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.dictionary.R
import com.example.dictionary.core.util.Resource
import com.example.dictionary.feature_dictionary.domain.model.Word
import com.example.dictionary.feature_dictionary.domain.repository.RetrieveWordRepo
import com.example.dictionary.feature_dictionary.domain.use_case.FetchWord
import kotlinx.coroutines.flow.Flow

class WordActivity : AppCompatActivity() {

    private val viewModel: WordViewModel by viewModels<WordViewModel> {
        ViewModelFactory(FetchWord(object: RetrieveWordRepo{
            override fun retrieveWord(word: String): Flow<Resource<List<Word>>> {
                TODO("Not yet implemented")
            }
        }))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)
    }
}