package com.ismail.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.ismail.moviecatalogue.data.source.local.entity.MovieEntity
import com.ismail.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ismail.moviecatalogue.data.CatalogueRepository

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    private val movieId = MutableLiveData<String>()
    private val tvId = MutableLiveData<String>()
    fun setSelectedMovie(id: String) {
        this.movieId.value = id
    }
    fun setSelectedTvShow(id: String) {
        this.tvId.value = id
    }

    var movie: LiveData<MovieEntity> = Transformations.switchMap(movieId){ id ->
        catalogueRepository.getMovieById(id)
    }


    var tvShow: LiveData<TvShowEntity> =  Transformations.switchMap(tvId){ id ->
        catalogueRepository.getTvShowById(id)
    }
    fun setMovieFavorite() {
        val resource = movie.value
        if (resource != null) {
            val newState =! resource.favorited
            catalogueRepository.setMovieFavorite(resource, newState)
        }
    }
    fun setTvShowFavorite() {
        val resource = tvShow.value
        if (resource != null) {
            val newState =! resource.favorited
            catalogueRepository.setTvShowFavorite(resource, newState)
        }
    }

}

