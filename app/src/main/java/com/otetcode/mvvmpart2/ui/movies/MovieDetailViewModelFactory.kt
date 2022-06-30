package com.otetcode.mvvmpart2.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.otetcode.mvvmpart2.data.repositories.JsRepository
import com.otetcode.mvvmpart2.data.repositories.MovieRepository

class MovieDetailViewModelFactory(private val repository: JsRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailViewModel(repository) as T
    }
}