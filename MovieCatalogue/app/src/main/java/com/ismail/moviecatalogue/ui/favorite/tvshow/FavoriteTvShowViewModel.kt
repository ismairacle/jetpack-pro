package com.ismail.moviecatalogue.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ismail.moviecatalogue.core.data.CatalogueRepository
import com.ismail.moviecatalogue.core.data.source.local.entity.TvShowEntity

class FavoriteTvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getFavoritedTvShow(): LiveData<PagedList<TvShowEntity>> = catalogueRepository.getFavoriteTvShows()
}