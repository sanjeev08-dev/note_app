package com.sanjeevdev.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.sanjeevdev.noteapp.repository.NotesRepository
import com.sanjeevdev.noteapp.viewModel.NotesViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var notesViewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notesViewModel =ViewModelProvider(this).get(NotesViewModel::class.java)
    }
}