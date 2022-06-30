package com.otetcode.mvvmpart2.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.otetcode.mvvmpart2.util.Corountines
import com.otetcode.mvvmpart2.data.Movie
import com.otetcode.mvvmpart2.data.repositories.MovieRepository
import kotlinx.coroutines.Job

//penghubung antara data repositori dan ui
class MoviesViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    //MutableLiveData bisa kita ubah valuye-nya sedangkan LiveData bersifat Read-Only

    private lateinit var job:Job
    //Job adalah sebuah hasil dari perintah asynchronous yang dijalankan

    val movies : LiveData<List<Movie>> //LiveData adalah class penyimpanan data observable atau data dari hasil pengamatan
    get() = _movies


    fun getMovies(){
        job = Corountines.ioThenMain(
            {
                repository.getMovie()
            },{
                _movies.value = it
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }

}
