package com.ismail.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ismail.moviecatalogue.data.source.local.entity.MovieEntity
import com.ismail.moviecatalogue.data.CatalogueRepository
import com.ismail.moviecatalogue.vo.Resource

class MovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = catalogueRepository.getAllMovies()
}
