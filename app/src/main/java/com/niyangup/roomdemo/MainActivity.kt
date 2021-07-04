package com.niyangup.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.niyangup.roomdemo.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread
import androidx.databinding.DataBindingUtil as DataBindingUtil1

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataBase: WordDatabase

    private val myViewModel: MyViewModel by lazy {
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(MyViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil1.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        dataBase = WordDatabase.getWordDatabase(this)

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = MyAdapter(myViewModel.select() ?: arrayListOf())

        myViewModel.wordRepository.allWords.observe(this) {
            val adapter = MyAdapter(it ?: arrayListOf())
            binding.rv.adapter = adapter
            adapter.notifyDataSetChanged()
        }


        binding.insert.setOnClickListener {
            myViewModel.insertWord()
        }
    }


    fun delete(view: View) {
        myViewModel.deleteWord()

    }

    fun update(view: View) {
        myViewModel.updateWord()

    }

    fun select(view: View) {
        myViewModel.select()
    }
}













