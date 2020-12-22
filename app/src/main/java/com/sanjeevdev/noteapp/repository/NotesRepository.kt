package com.sanjeevdev.noteapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.sanjeevdev.noteapp.Dao.NotesDao
import com.sanjeevdev.noteapp.database.NotesDatabase
import com.sanjeevdev.noteapp.model.Notes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class NotesRepository {
    companion object{
        private var notesDatabase:NotesDatabase? = null
        fun initializeDB(context: Context):NotesDatabase?{
            return NotesDatabase.getInstance(context)
        }
        fun insert(context: Context,notes: Notes){
            notesDatabase = initializeDB(context)
            CoroutineScope(IO).launch {
                notesDatabase?.getDao()?.insert(notes)
            }
        }

        fun getAllNotes(context: Context) : LiveData<List<Notes>>? {
            notesDatabase = initializeDB(context)
            return notesDatabase?.getDao()?.getAllNotes()
        }
    }
}