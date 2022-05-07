package com.example.dictionary.feature_dictionary.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dictionary.feature_dictionary.domain.use_case.FetchWord

class ViewModelFactory(private val fetchWord: FetchWord): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            return WordViewModel(fetchWord) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}