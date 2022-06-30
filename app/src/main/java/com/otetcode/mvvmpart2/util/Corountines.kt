package com.otetcode.mvvmpart2.util

import kotlinx.coroutines.*

object Corountines {

    fun<T: Any> ioThenMain(work: suspend (() -> T?), callback: ((T?)-> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.IO).async rt@{
                return@rt work()
            }.await()
            callback(data)

    }

    suspend fun withContextIO(work : suspend (() -> Unit)){
        withContext(Dispatchers.IO) {
            work()
        }
    }

    fun main(work : suspend (() -> Unit)){
        CoroutineScope(Dispatchers.Main).launch {
            work()
            //when we say launch this will fire up a new coroutine
        }
    }
}

// Proses Asyncrhonous adalah proses pengeksekusian kode yang tidak
// sesuai dengan urutan yang ada atau bisa disebut
// menjalankan perintah selanjutnya tanpa menunggu perintah sebelumnya selesai.