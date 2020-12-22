package com.sanjeevdev.noteapp.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sanjeevdev.noteapp.model.Notes
import com.sanjeevdev.noteapp.repository.NotesRepository

class NotesViewModel:ViewModel() {
    fun insert(context: Context,notes: Notes){
        NotesRepository.insert(context,notes)
    }
    fun getAllNotes(context: Context): LiveData<List<Notes>>?{
        return NotesRepository.getAllNotes(context)
    }
}