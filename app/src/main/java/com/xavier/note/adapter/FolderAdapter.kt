package com.xavier.note.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xavier.note.R
import com.xavier.note.entities.Folder
import kotlinx.android.synthetic.main.item_folder.view.*

class FolderAdapter(
    val context: Context,
    val folderClickInterface: FolderClickInterface
) :
    RecyclerView.Adapter<FolderAdapter.ViewHolder>() {

    private val allFolders = ArrayList<Folder>()



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)




    interface FolderClickInterface {
        fun onFolderClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_folder,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val curFolder = allFolders[position]
        holder.itemView.tvFolderTitle.text=curFolder.folderName
        holder.itemView.setOnClickListener{
            folderClickInterface.onFolderClick(position)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Folder>) {
        allFolders.clear()
        allFolders.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = allFolders.size
}