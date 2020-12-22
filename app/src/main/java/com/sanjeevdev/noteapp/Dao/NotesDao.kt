package com.sanjeevdev.noteapp.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sanjeevdev.noteapp.model.Notes

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(notes: Notes)

    @Query("SELECT * FROM notes ORDER BY id ASC")
    fun getAllNotes() : LiveData<List<Notes>>
}