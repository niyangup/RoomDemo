package com.niyangup.roomdemo

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {

    @Insert
    fun insert(vararg word: Word)

    @Delete
    fun delete(vararg word: Word)

    @Update
    fun update(vararg word: Word)

    @Query("delete from word where id = :id")
    fun deleteWordById(vararg id: Int)

    @Query("delete from word")
    fun clear()

    @Query("select * from word order by id desc")
    fun getAllWords(): LiveData<List<Word>>

    @Query("select * from word where id = :id")
    fun selectWordById(id: Int): Word
}