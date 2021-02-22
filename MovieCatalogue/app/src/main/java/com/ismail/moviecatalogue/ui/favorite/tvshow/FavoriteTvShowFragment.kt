package com.ismail.moviecatalogue.ui.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ismail.moviecatalogue.databinding.FragmentFavoriteTvShowBinding
import com.ismail.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorite_tv_show.*

class FavoriteTvShowFragment : Fragment() {

    private var _fragmentFavoritTvShowFragment: FragmentFavoriteTvShowBinding? = null
    private val binding get() = _fragmentFavoritTvShowFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _fragmentFavoritTvShowFragment = FragmentFavoriteTvShowBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavoriteTvShowViewModel::class.java]

            val tvShowAdapter = FavoriteTvShowAdapter()
            viewModel.getFavoritedTvShow().observe(viewLifecycleOwner, { tvShows ->
                progress_bar.visibility = View.GONE
                tvShowAdapter.submitList(tvShows)
                tvShowAdapter.notifyDataSetChanged()


            })

            with(binding?.rvFavoritedTvshow) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = tvShowAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentFavoritTvShowFragment = null
    }

}