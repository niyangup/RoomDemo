package com.niyangup.roomdemo

import android.app.Application
import androidx.lifecycle.LiveData
import kotlin.concurrent.thread

class WordRepository(application: Application) {
    private val wordDao: WordDao = WordDatabase.getWordDatabase(application).wordDao()
    val allWords: LiveData<List<Word>> = wordDao.getAllWords()


    fun insertWord() {
        thread {
            val word = Word(word = "hello", chineseMeaning = "你好")
            val word2 = Word(word = "world", chineseMeaning = "世界")
            wordDao.insert(word, word2)
        }
    }

    fun deleteWord() {
        thread {
            wordDao.clear()
        }
    }

    fun updateWord() {
        thread {
            val word = wordDao.selectWordById(12)
            word.chineseMeaning = "shijie"
            wordDao.update(word)
        }
    }

    fun select() {
        thread {

        }
    }

}