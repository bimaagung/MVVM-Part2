package com.otetcode.mvvmpart2.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.otetcode.mvvmpart2.data.JS
import com.otetcode.mvvmpart2.data.Movie
import com.otetcode.mvvmpart2.data.repositories.JsRepository
import com.otetcode.mvvmpart2.data.repositories.MovieRepository
import com.otetcode.mvvmpart2.util.Corountines
import kotlinx.coroutines.Job

class MovieDetailViewModel(private val repository:JsRepository) : ViewModel() {

    private val _jp_detail = MutableLiveData<List<JS>>()
    private lateinit var job: Job

//     val mDetail = repository.getMovie()

    private val _title = MutableLiveData<String>()
    val title : LiveData<String>
        get() = _title

    private val _id = MutableLiveData<Int>()
    val id : LiveData<Int>
        get() = _id


    suspend fun DetailJp(){
        repository.getJPDetail()
        _title.value = repository.detailTitle?.value
        _id.value = repository.detailId?.value
    }

}
