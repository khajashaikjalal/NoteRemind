package com.khaja.noteremind.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.khaja.noteremind.data.Note
import com.khaja.noteremind.data.NoteDatabase
import com.khaja.noteremind.data.NoteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = NoteRepository(NoteDatabase.getInstance(application).noteDao())

    // Expose notes as a StateFlow-like object so Compose can collect it easily
    val notes = repo.getAllNotes()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addNote(title: String, content: String, reminderMinutes: Long?) {
        viewModelScope.launch {
            repo.insertNote(Note(title = title, content = content, reminderMinutesFromNow = reminderMinutes))
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repo.deleteNote(note)
        }
    }
}
