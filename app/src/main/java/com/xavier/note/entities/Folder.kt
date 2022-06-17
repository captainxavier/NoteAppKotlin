package com.xavier.note.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// on below line we are specifying our table name
@Entity(tableName = "note_folder")
data class Folder(
    @ColumnInfo(name = "folder_name")val folderName :String,
    @ColumnInfo(name = "timestamp")val timeStamp :String) {
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}