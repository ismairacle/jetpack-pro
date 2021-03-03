package com.ismail.moviecatalogue.ui.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ismail.moviecatalogue.databinding.FragmentFavoriteMovieBinding
import com.ismail.moviecatalogue.core.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorite_movie.*


class FavoriteMovieFragment : Fragment() {

    private var _fragmentFavoriteMovieBinding: FragmentFavoriteMovieBinding? = null
    private val binding get() = _fragmentFavoriteMovieBinding
    private lateinit var viewModel: FavoriteMovieViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _fragmentFavoriteMovieBinding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]

            val movieAdapter = FavoriteMovieAdapter()
            viewModel.getFavoritedMovies().observe(viewLifecycleOwner, { movies ->
                progress_bar.visibility = View.GONE
                movieAdapter.submitList(movies)
                movieAdapter.notifyDataSetChanged()
            })

            with(binding?.rvFavoritedMovie) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = movieAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentFavoriteMovieBinding = null
    }
}