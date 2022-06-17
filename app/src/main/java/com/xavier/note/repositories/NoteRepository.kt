package com.xavier.note.repositories

import androidx.lifecycle.LiveData
import com.xavier.note.database.NotesDao
import com.xavier.note.entities.Note

class NoteRepository(private val notesDao: NotesDao) {
    val allNotes: LiveData<List<Note>> = notesDao.getAllNotes()

    suspend fun insertNote(note: Note) {
        notesDao.insertNote(note)
    }
    suspend fun deleteNote(note: Note){
        notesDao.deleteNote(note)
    }

    suspend fun updateNote(note: Note){
        notesDao.updateNote(note)
    }
}