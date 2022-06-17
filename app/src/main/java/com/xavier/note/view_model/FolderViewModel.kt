package com.xavier.note.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.xavier.note.database.NotesDatabase
import com.xavier.note.entities.Folder
import com.xavier.note.entities.FolderWithNotes
import com.xavier.note.repositories.FolderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FolderViewModel(application: Application):AndroidViewModel(application) {

    val allFolder : LiveData<List<Folder>>
    val allFolderWithNotes : LiveData<List<FolderWithNotes>>
    val repository : FolderRepository

    init {
        val dao = NotesDatabase.getDatabase(application).getFolderDao()
        repository = FolderRepository(dao)
        allFolder = repository.allNotes
        allFolderWithNotes = repository.allFolderNotes
    }

    fun deleteNFolder (folder: Folder) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteFolder(folder)
    }

    fun updateFolder(folder: Folder) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateFolder(folder)
    }

    fun addNote(folder: Folder) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertFolder(folder)
    }
}