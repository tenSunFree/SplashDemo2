package com.home.splashdemo2.photopreview.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.home.data.entity.CommentEntity
import com.home.splashdemo2.photopreview.holder.PhotoPreviewHolder
import com.home.splashdemo2.photopreview.utils.CommentsDiffUtil
import com.home.splashdemo2.utils.inflate
import com.home.splashdemo2.R

class PhotoPreviewAdapter(
    private val items: MutableList<CommentEntity> = mutableListOf()
) : RecyclerView.Adapter<PhotoPreviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoPreviewHolder {
        return PhotoPreviewHolder(parent.inflate(R.layout.photo_list_item))
    }

    override fun onBindViewHolder(holder: PhotoPreviewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(newItems: MutableList<CommentEntity>) {
        val diffUtil = CommentsDiffUtil(newItems, items)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtil)
        items.clear()
        items.addAll(newItems)
        diffUtilResult.dispatchUpdatesTo(this)
    }
}