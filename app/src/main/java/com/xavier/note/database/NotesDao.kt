package com.xavier.note.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.xavier.note.entities.Note

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note : Note)
    @Delete
    suspend fun deleteNote(note: Note)
    @Query("Select * from notes order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>
    @Update
    suspend fun updateNote(note: Note)
}