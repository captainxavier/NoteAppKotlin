package com.xavier.note.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.xavier.note.entities.Note
import com.xavier.note.entities.Folder

@Database(entities = [Folder::class,Note::class], version = 1, exportSchema = false)
abstract class NotesDatabase: RoomDatabase(){

    abstract fun getFolderDao(): FoldersDao
    abstract fun getNotesDao(): NotesDao

    companion object {
        // Singleton prevents multiple
        // instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: NotesDatabase? = null

        fun getDatabase(context: Context): NotesDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}