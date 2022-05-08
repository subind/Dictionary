package com.example.dictionary.feature_dictionary.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionary.core.util.Resource
import com.example.dictionary.feature_dictionary.domain.model.Word
import com.example.dictionary.feature_dictionary.domain.use_case.FetchWord
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class WordViewModel(private var fetchWordUseCase: FetchWord): ViewModel() {

    /*private var _searchQueryStateFlow = MutableStateFlow<String>("")
    var searchQueryStateFlow: MutableStateFlow<String> = _searchQueryStateFlow*/

    private val _wordsStateFlow = MutableStateFlow<List<Word>>(emptyList())
    val wordsStateFlow: StateFlow<List<Word>> = _wordsStateFlow

    private val _isLoadingSharedFlow = MutableSharedFlow<Boolean>()
    val isLoadingSharedFlow: SharedFlow<Boolean> = _isLoadingSharedFlow

    private val _hasErrorSharedFlow = MutableSharedFlow<String>()
    val hasErrorSharedFlow: SharedFlow<String> = _hasErrorSharedFlow

    private var searchJob: Job? = null

    fun search(query: String) {
        //_searchQueryStateFlow.value = query
        searchJob?.cancel()
        searchJob = viewModelScope.launch(Dispatchers.IO) {
            fetchWordUseCase.fetch(query).onEach { result ->
                when(result) {
                    is Resource.Success -> {
                        _wordsStateFlow.value = result.data ?: emptyList()
                    }
                    is Resource.Error -> {
                        _hasErrorSharedFlow.emit(result.message ?: "")
                    }
                    is Resource.Loading -> {
                        _isLoadingSharedFlow.emit(result.isLoading)
                    }
                }
            }
        }

    }

}