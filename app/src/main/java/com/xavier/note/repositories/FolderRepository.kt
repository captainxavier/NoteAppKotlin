package com.xavier.note.repositories

import androidx.lifecycle.LiveData
import com.xavier.note.database.FoldersDao
import com.xavier.note.entities.FolderWithNotes
import com.xavier.note.entities.Folder

class FolderRepository(private val foldersDao: FoldersDao) {

    val allNotes: LiveData<List<Folder>> = foldersDao.getAllNoteFolders()

    val allFolderNotes: LiveData<List<FolderWithNotes>> = foldersDao.getFolderWithNotes()

    suspend fun insertFolder(folder: Folder) {
        foldersDao.insertNoteFolder(folder)
    }

    suspend fun deleteFolder(folder: Folder){
        foldersDao.deleteNoteFolder(folder)
    }

    suspend fun updateFolder(folder: Folder){
        foldersDao.updateNoteFolder(folder)
    }
}