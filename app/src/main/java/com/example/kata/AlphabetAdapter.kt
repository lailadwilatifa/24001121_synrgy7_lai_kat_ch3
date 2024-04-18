package com.example.kata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class AlphabetAdapter(private val listWord: ArrayList<MyWord>)
    : RecyclerView.Adapter<AlphabetAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val btnAlphabet = itemView.findViewById<Button>(R.id.btn_alphabet)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphabetAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.alphabet_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlphabetAdapter.ViewHolder, position: Int) {
        holder.btnAlphabet.text = listWord[position].alphabet
        holder.btnAlphabet.setOnClickListener {
            val action = AlphabetFragmentDirections.actionAlphabetFragmentToWordFragment(listWord[position])
            action.myWord = listWord[position]
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return listWord.size
    }
}