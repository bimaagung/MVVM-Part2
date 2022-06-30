package com.otetcode.mvvmpart2.data.network

import com.otetcode.mvvmpart2.data.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieApi {

    //mengambil data
    @GET("movies")
    suspend fun getMovies(): Response<List<Movie>>

    //mengambil satu data
//    @GET("movies")
//    suspend fun getMovieDetail(): Response<Movie>

    //configurasi retrofit
    companion object{
        operator fun invoke(): MovieApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.simplifiedcoding.in/course-apis/recyclerview/")
                .build()
                .create(MovieApi::class.java) //impementasi di class movie
        }
    }
}