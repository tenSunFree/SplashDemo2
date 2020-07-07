package com.home.splashdemo2.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class SplashViewHolder<DataType>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(data: DataType)
}