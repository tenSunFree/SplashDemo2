package com.home.splashdemo2.photopreview.utils

import androidx.recyclerview.widget.DiffUtil
import com.home.data.entity.CommentEntity

class CommentsDiffUtil(
    private val newItems: MutableList<CommentEntity>,
    private val oldItems: MutableList<CommentEntity>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].id == newItems[newItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }
}