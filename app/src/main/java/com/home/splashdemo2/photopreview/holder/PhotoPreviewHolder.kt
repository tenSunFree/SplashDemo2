package com.home.splashdemo2.photopreview.holder

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.home.data.entity.CommentEntity
import kotlinx.android.synthetic.main.photo_list_item.view.*

class PhotoPreviewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val idTextView: TextView = view.text_view_id
    private val nameTextView: TextView = view.text_view_name

    @SuppressLint("SetTextI18n")
    fun bind(entity: CommentEntity) {
        entity.apply {
            idTextView.text = "Id: $id"
            nameTextView.text = "Name: $name"
        }
    }
}