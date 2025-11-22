package com.khaja.noteremind.data

import kotlinx.coroutines.flow.Flow

class NoteRepository(private val dao: NoteDao) {
    fun getAllNotes(): Flow<List<Note>> = dao.getAllNotes()
    suspend fun insertNote(note: Note): Long = dao.insertNote(note)
    suspend fun deleteNote(note: Note) = dao.deleteNote(note)
}
