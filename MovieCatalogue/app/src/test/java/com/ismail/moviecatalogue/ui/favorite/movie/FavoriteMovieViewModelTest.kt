package com.ismail.moviecatalogue.ui.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.ismail.moviecatalogue.data.CatalogueRepository

import com.ismail.moviecatalogue.data.source.local.entity.MovieEntity
import com.ismail.moviecatalogue.ui.favorite.movie.FavoriteMovieViewModel

import com.ismail.moviecatalogue.vo.Resource
import com.ismail.moviecatalogue.vo.Resource.Companion.success

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
class FavoriteMovieViewModelTest {

    private lateinit var viewModel: FavoriteMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteMovieViewModel(catalogueRepository)
    }

    @Test
    fun getFavMovies() {

        val dummyFavMovies = pagedList
        `when`(dummyFavMovies.size).thenReturn(10)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyFavMovies

        `when`(catalogueRepository.getFavoriteMovies()).thenReturn(movies)
        val movieEntities = viewModel.getFavoritedMovies().value
        verify(catalogueRepository).getFavoriteMovies()
        assertNotNull(movieEntities)
        if (movieEntities != null) {
            assertEquals(10, movieEntities.size)
        }

        viewModel.getFavoritedMovies().observeForever(observer)
        verify(observer).onChanged(dummyFavMovies)
    }
}