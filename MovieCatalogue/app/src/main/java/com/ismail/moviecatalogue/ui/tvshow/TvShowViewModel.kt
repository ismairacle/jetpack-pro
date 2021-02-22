package com.ismail.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ismail.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ismail.moviecatalogue.data.CatalogueRepository
import com.ismail.moviecatalogue.vo.Resource

class TvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> = catalogueRepository.getAllTvShows()
}