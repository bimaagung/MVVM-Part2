package com.otetcode.mvvmpart2.data.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.otetcode.mvvmpart2.data.network.jpApi
import com.otetcode.mvvmpart2.util.Corountines

class JsRepository (private val api: jpApi) : SafeApiRequest() {

    val detailTitle = MutableLiveData<String>()
    val detailId = MutableLiveData<Int>()

    suspend fun getJPDetail() {
        return Corountines.withContextIO{
            fetchDetailJP()
            //findCountryFullInfo
        }
    }

    private suspend fun fetchDetailJP(){
        try {
            val response = apiRequest { api.getJPDetail()}
           detailTitle.postValue(response.title)
           detailId.postValue(response.id)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("hellohello", "Error Repository +${e.toString()} ")

        }
    }


}
