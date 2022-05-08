package com.example.dictionary.feature_dictionary.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.R
import com.example.dictionary.feature_dictionary.domain.model.Word
import com.example.dictionary.feature_dictionary.domain.use_case.FetchWord
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class WordActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var editText: EditText
    private lateinit var progressLoader: ProgressBar
    private lateinit var fetchWord: FetchWord

    private val viewModel: WordViewModel by viewModels<WordViewModel> {
        ViewModelFactory(fetchWord)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)

        initView()
        initObservers()
    }

    private fun initView() {
        initRecyclerAdapter()
        editText = findViewById<EditText>(R.id.et_search)
        progressLoader = findViewById<ProgressBar>(R.id.pg_bar)
        setEditTextListener()
    }

    private fun initRecyclerAdapter() {
        recyclerView = findViewById<RecyclerView>(R.id.rv_word)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
    }

    private fun setDataToRecyclerView(words: List<Word>) {
        val adapter = WordRecyclerAdapter(words)
        adapter.notifyDataSetChanged()
        recyclerView.adapter = WordRecyclerAdapter(words)
    }

    private fun initObservers() {
        lifecycleScope.launch {
            viewModel.wordsStateFlow.collectLatest { words ->
                setDataToRecyclerView(words)
            }

            viewModel.isLoadingSharedFlow.collectLatest {
                progressLoader.visibility = if (it) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }

            viewModel.hasErrorSharedFlow.collectLatest {
                Toast.makeText(this@WordActivity, it, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setEditTextListener() {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //viewModel.searchQueryStateFlow.value = editText.text.toString()
                viewModel.search(editText.text.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }
}




