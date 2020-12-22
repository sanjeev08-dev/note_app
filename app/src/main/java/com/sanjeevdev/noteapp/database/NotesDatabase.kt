package com.sanjeevdev.noteapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sanjeevdev.noteapp.Dao.NotesDao
import com.sanjeevdev.noteapp.model.Notes

@Database(entities = [Notes::class],version = 1,exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {

    abstract  fun  getDao(): NotesDao

    companion object{
        private const val DATABASE_NAME = "NotesDatabase"

        @Volatile
        var instance : NotesDatabase? = null

        fun getInstance(context: Context): NotesDatabase?{
            if (instance == null){
                synchronized(NotesDatabase::class.java){
                    if (instance == null){
                        instance = Room.databaseBuilder(context,NotesDatabase::class.java, DATABASE_NAME).build()
                    }
                }
            }
            return instance
        }
    }
}