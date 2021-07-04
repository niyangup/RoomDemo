package com.niyangup.roomdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Word::class], version = 2, exportSchema = false)
abstract class WordDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object {
        private var instance: WordDatabase? = null

        @Synchronized
        fun getWordDatabase(context: Context): WordDatabase {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(context.applicationContext, WordDatabase::class.java, "word_database")
//                        .allowMainThreadQueries()
                        .build()
            }
            return instance!!
        }
    }

}