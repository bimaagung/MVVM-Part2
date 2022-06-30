package com.otetcode.mvvmpart2.ui.movies

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.whenCreated
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.otetcode.mvvmpart2.R
import com.otetcode.mvvmpart2.data.Movie
import com.otetcode.mvvmpart2.data.network.MovieApi
import com.otetcode.mvvmpart2.data.repositories.MovieRepository
import kotlinx.android.synthetic.main.movies_fragment.*


class MoviesFragment : Fragment(), RecyclerViewClickListener {

    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = MovieApi() //connection api
        val repository = MovieRepository(api) //impementasnt api to repository
        factory = MoviesViewModelFactory(repository) //deklarasi repository ke view model
        viewModel = ViewModelProviders.of(this, factory).get(MoviesViewModel::class.java) //Implementasi view model dalam fragment
        viewModel.getMovies() //ambil data lewat view model
        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            recycler_view_movies.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = MoviesAdapter(movies, this)
            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, movie: Movie) {
        when(view.id){
            R.id.tb_book -> {
                Toast.makeText(requireContext(), "Ini Tombol Klik", Toast.LENGTH_LONG).show()
                Navigation.findNavController(view).navigate(R.id.action_moviesFragment_to_movieDetailFragment)
            }
        }
    }


}
