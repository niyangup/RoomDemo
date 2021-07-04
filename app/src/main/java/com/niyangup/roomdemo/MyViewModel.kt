package com.niyangup.roomdemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlin.concurrent.thread

class MyViewModel(application: Application) : AndroidViewModel(application) {
    fun insertWord() = wordRepository.insertWord()
    fun deleteWord() {
        wordRepository.deleteWord()
    }

    fun updateWord() {
        wordRepository.updateWord()
    }

    fun select(): List<Word>? {
        return wordRepository.allWords.value
    }

    val wordRepository: WordRepository by lazy {
        WordRepository(application)
    }

}