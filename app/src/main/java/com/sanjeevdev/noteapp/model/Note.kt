package com.sanjeevdev.noteapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Notes(
    val title:String,
    val description:String,
    val time:String,
    val url:String
){
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null
}