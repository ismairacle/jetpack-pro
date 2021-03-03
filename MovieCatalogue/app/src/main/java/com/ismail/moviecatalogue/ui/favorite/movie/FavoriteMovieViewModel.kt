package com.ismail.moviecatalogue.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ismail.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.ismail.moviecatalogue.core.data.CatalogueRepository

class FavoriteMovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getFavoritedMovies(): LiveData<PagedList<MovieEntity>> = catalogueRepository.getFavoriteMovies()
}
