package com.xavier.note.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.xavier.note.R
import com.xavier.note.entities.Folder
import com.xavier.note.view_model.FolderViewModel
import kotlinx.android.synthetic.main.activity_add_edit_note.*
import java.text.SimpleDateFormat
import java.util.*

class AddEditNoteActivity : AppCompatActivity() {

    private lateinit var folderViewModel: FolderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_note)

        folderViewModel =
            ViewModelProvider(this)[FolderViewModel::class.java]

        initAddFolder()
    }

    private fun initAddFolder() {
        addBtn.setOnClickListener {
            if (idEdtNFolderName.text.isNotEmpty()){
                val title = idEdtNFolderName.text.toString()
                val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                val currentDateAndTime: String = sdf.format(Date())
                folderViewModel.addNote(Folder(title,currentDateAndTime))
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}