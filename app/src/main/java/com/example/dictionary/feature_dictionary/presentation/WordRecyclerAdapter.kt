package com.example.dictionary.feature_dictionary.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.R
import com.example.dictionary.feature_dictionary.domain.model.Word
import com.example.dictionary.feature_dictionary.presentation.WordRecyclerAdapter.*

class WordRecyclerAdapter(private val words: List<Word>): RecyclerView.Adapter<WordRecyclerViewHolder>() {

    class WordRecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvWord: TextView = itemView.findViewById(R.id.tv_word)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        return WordRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordRecyclerViewHolder, position: Int) {
        holder.tvWord.text = words[position].word
    }

    override fun getItemCount(): Int = words.size

}