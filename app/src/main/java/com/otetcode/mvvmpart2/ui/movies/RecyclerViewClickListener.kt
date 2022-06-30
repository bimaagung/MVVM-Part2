package com.otetcode.mvvmpart2.ui.movies

import android.view.View
import com.otetcode.mvvmpart2.data.Movie

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view:View, movie:Movie)
}