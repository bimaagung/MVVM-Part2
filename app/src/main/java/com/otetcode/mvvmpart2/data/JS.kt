package com.otetcode.mvvmpart2.data


import com.google.gson.annotations.SerializedName

data class JS(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)