package com.xavier.note.entities

import androidx.room.Embedded
import androidx.room.Relation

data class FolderWithNotes(
    @Embedded
    val folder:Folder,
    @Relation(
        parentColumn = "id",
        entityColumn = "folder_id")
    val notes : List<Note>
) {


}