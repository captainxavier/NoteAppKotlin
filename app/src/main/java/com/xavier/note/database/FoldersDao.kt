package com.xavier.note.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.xavier.note.entities.FolderWithNotes
import com.xavier.note.entities.Folder

@Dao
interface FoldersDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNoteFolder(folder: Folder)

    @Delete
    suspend fun deleteNoteFolder(folder: Folder)

    @Query("Select * from note_folder order by id ASC")
    fun getAllNoteFolders(): LiveData<List<Folder>>

    @Update
    suspend fun updateNoteFolder(folder: Folder)

    @Transaction
    @Query("SELECT * FROM note_folder")
    fun getFolderWithNotes(): LiveData<List<FolderWithNotes>>
}