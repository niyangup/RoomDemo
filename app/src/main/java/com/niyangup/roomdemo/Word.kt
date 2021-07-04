package com.niyangup.roomdemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word")//Room表示创建实体类
data class Word(

    @ColumnInfo(name = "english_word")
    var word: String,

    @ColumnInfo(name = "chinese_meaning")
    var chineseMeaning: String

) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}