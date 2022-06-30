package com.otetcode.mvvmpart2.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.otetcode.mvvmpart2.R
import com.otetcode.mvvmpart2.data.Movie
import com.otetcode.mvvmpart2.databinding.RecyclerviewMovieBinding

class MoviesAdapter ( private val movies: List<Movie>, private val listener: RecyclerViewClickListener) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MoviesViewHolder(
        DataBindingUtil.inflate<RecyclerviewMovieBinding>(
            LayoutInflater.from(parent.context),
            R.layout.recyclerview_movie,
            parent,
            false
        )
    )

    override fun getItemCount() = movies.size


    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.recyclerviewMovieBinding.movie = movies[position]
        holder.recyclerviewMovieBinding.tbBook.setOnClickListener{
            listener.onRecyclerViewItemClick(holder.recyclerviewMovieBinding.tbBook, movies[position])
        }
    }



    inner class MoviesViewHolder( val recyclerviewMovieBinding: RecyclerviewMovieBinding) : RecyclerView.ViewHolder(recyclerviewMovieBinding.root)
}