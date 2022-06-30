package com.otetcode.mvvmpart2.data.network

import com.otetcode.mvvmpart2.data.JS
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface jpApi {
    //mengambil data
    @GET("1")
    suspend fun getJPDetail(): Response<JS>

    //configurasi retrofit
    companion object{
        operator fun invoke(): jpApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/todos/")
                .build()
                .create(jpApi::class.java) //impementasi di class movie
        }
    }
}