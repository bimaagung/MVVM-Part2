package com.otetcode.mvvmpart2.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.otetcode.mvvmpart2.data.repositories.MovieRepository

class MoviesViewModelFactory(private val repository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(repository) as T
    }
}