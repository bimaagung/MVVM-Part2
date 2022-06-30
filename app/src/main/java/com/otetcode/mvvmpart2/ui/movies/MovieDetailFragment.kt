package com.otetcode.mvvmpart2.ui.movies

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.otetcode.mvvmpart2.R
import com.otetcode.mvvmpart2.databinding.MovieDetailFragmentBinding
import com.otetcode.mvvmpart2.util.Corountines
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class MovieDetailFragment : Fragment(), KodeinAware {

    private lateinit var viewModel:MovieDetailViewModel
    override val kodein by kodein()
    private val factory: MovieDetailViewModelFactory by instance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      // return inflater.inflate(R.layout.movie_detail_fragment, container, false)

        viewModel = ViewModelProviders.of(this, factory).get(MovieDetailViewModel::class.java)

        val binding = DataBindingUtil.inflate<MovieDetailFragmentBinding>(inflater,
            R.layout.movie_detail_fragment, container, false).apply {
            this.lifecycleOwner = activity
            this.movied = viewModel
            bindUI()
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProviders.of(this, factory).get(CountryDetailsViewModel::class.java)
        Log.d("fraglifecycle", "onActivityCreated")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("fraglifecycle", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("fraglifecycle", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("fraglifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("fraglifecycle", "onResume")
    }


    private fun bindUI() = Corountines.main{
        //progressBar.show()
        viewModel.DetailJp()
    }

}
