package com.otetcode.mvvmpart2.data.repositories

import androidx.lifecycle.LiveData
import com.otetcode.mvvmpart2.data.Movie
import com.otetcode.mvvmpart2.data.network.MovieApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//gudang hasil data
class MovieRepository (private val api: MovieApi) : SafeApiRequest() {
    suspend fun getMovie() = apiRequest{
        api.getMovies() //mengambil data
    }

//    suspend fun getJSDetail() = apiRequest{
//        api.getMovieDetail() //mengambil data
//    }


}
