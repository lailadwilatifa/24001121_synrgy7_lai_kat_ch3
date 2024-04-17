package com.example.kata

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyWord(val alphabet: String, val words: ArrayList<String>): Parcelable