package com.ismail.moviecatalogue.ui.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.ismail.moviecatalogue.core.data.CatalogueRepository

import com.ismail.moviecatalogue.core.data.source.local.entity.TvShowEntity

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class FavoriteTvShowViewModelTest {

    private lateinit var viewModel: FavoriteTvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteTvShowViewModel(catalogueRepository)
    }

    @Test
    fun getFavTvShow() {

        val dummyFavTvShow = pagedList
        `when`(dummyFavTvShow.size).thenReturn(10)
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = dummyFavTvShow

        `when`(catalogueRepository.getFavoriteTvShows()).thenReturn(tvShow)
        val tvShowEntity = viewModel.getFavoritedTvShow().value
        verify(catalogueRepository).getFavoriteTvShows()
        assertNotNull(tvShowEntity)
        if (tvShowEntity != null) {
            assertEquals(10, tvShowEntity.size)
        }

        viewModel.getFavoritedTvShow().observeForever(observer)
        verify(observer).onChanged(dummyFavTvShow)
    }
}