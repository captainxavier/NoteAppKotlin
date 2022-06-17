package com.xavier.note.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.xavier.note.R
import com.xavier.note.adapter.FolderAdapter
import com.xavier.note.entities.Folder
import com.xavier.note.view_model.FolderViewModel
import kotlinx.android.synthetic.main.fragment_file.*
import kotlinx.android.synthetic.main.layout_center_folder.*

class FolderFragment : Fragment() ,FolderAdapter.FolderClickInterface {
    private val TAG = "FolderFragment"
    private val folderViewModel: FolderViewModel by activityViewModels()
    private lateinit var adapter:FolderAdapter
    private lateinit var folders:List<Folder>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_file, container, false)
        Log.d(TAG, "onCreateView: started::")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvFolders.layoutManager = GridLayoutManager(activity,2)
        adapter = context?.let { FolderAdapter(it,this) }!!
        rvFolders.adapter = adapter
        initAddFabFolder()
        initAddBtnFolder()
        initFolders()
    }

    private fun initAddBtnFolder() {
        btnAddFolder.setOnClickListener {
            val intent = Intent (activity, AddEditNoteActivity::class.java)
            activity?.startActivity(intent)
        }
    }

    private fun initAddFabFolder() {
        fabFolderAdd.setOnClickListener {
            val intent = Intent (activity, AddEditNoteActivity::class.java)
            activity?.startActivity(intent)
        }

    }

    private fun initFolders() {
        folderViewModel.allFolder.observe(viewLifecycleOwner, Observer { list -> list.let {
            folders=it
            if (folders.isNotEmpty()){
                tvFolderText.visibility=View.INVISIBLE
                btnAddFolder.visibility=View.INVISIBLE
            }else{
                tvFolderText.visibility=View.VISIBLE
                btnAddFolder.visibility=View.VISIBLE
            }
            adapter.updateList(folders)
        } })
    }


    override fun onFolderClick(position:Int) {
        Log.d(TAG, "onFolderClick:"+folders.get(position))

    }

}