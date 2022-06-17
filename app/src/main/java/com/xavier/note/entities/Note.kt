package com.xavier.note.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "timestamp") val timeStamp: String,
    @ColumnInfo(name = "folder_id") val folderId: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}