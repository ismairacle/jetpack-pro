package com.ismail.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.ismail.moviecatalogue.core.data.CatalogueRepository
import com.ismail.moviecatalogue.core.data.source.local.entity.TvShowEntity
import com.ismail.moviecatalogue.core.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {


    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShowEntity>>>


    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>


    @Before
    fun setUp() {
        viewModel = TvShowViewModel(catalogueRepository)
    }

    @Test
    fun getTvShows() {

        val dummyTvShow = Resource.success(pagedList)
        Mockito.`when`(dummyTvShow.data?.size).thenReturn(10)
        val tvShows = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvShows.value = dummyTvShow

        Mockito.`when`(catalogueRepository.getAllTvShows()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getTvShow().value?.data
        Mockito.verify(catalogueRepository).getAllTvShows()
        assertNotNull(tvShowEntities)
        if (tvShowEntities != null) {
            assertEquals(10, tvShowEntities.size)
        }

        viewModel.getTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShow)
    }
}