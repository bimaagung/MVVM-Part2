package com.otetcode.mvvmpart2.data.repositories


import retrofit2.Response
import java.io.IOException

//Permintaan api untuk keamanan network
abstract class SafeApiRequest {

    suspend fun<T: Any> apiRequest(call: suspend () -> Response<T>) : T{
        val response = call.invoke()
        if(response.isSuccessful){
            //apabila network dapat di jangkau
            return response.body()!!
        }else{
            //gagal dalam menjangkau network
            //@todo handle api exception
            throw ApiException(response.code().toString())
        }
    }

}

//class ApiException(message: String): IOException(message)
class ApiException(message: String): IOException(message)