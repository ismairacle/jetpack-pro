package com.ismail.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ismail.moviecatalogue.core.data.CatalogueRepository
import com.ismail.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.ismail.moviecatalogue.core.data.source.local.entity.TvShowEntity
import com.ismail.moviecatalogue.ui.favorite.movie.FavoriteMovieViewModel
import com.ismail.moviecatalogue.ui.favorite.tvshow.FavoriteTvShowViewModel
import com.ismail.moviecatalogue.core.utils.DataDummy
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private lateinit var favoriteTvShowViewModel: FavoriteTvShowViewModel
    private lateinit var favoriteMovieViewModel: FavoriteMovieViewModel

    private val dummyMovies = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovies.id

    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val tvShowId = dummyTvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieObserver: Observer<MovieEntity>

    @Mock
    private lateinit var tvShowObserver: Observer<TvShowEntity>



    @Mock
    private lateinit var tvShowEntity: MutableLiveData<TvShowEntity>


    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogueRepository)
        favoriteMovieViewModel = FavoriteMovieViewModel(catalogueRepository)
        favoriteTvShowViewModel = FavoriteTvShowViewModel(catalogueRepository)
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }


    @Test
    fun getMovie() {

        val movies = MutableLiveData<MovieEntity>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getMovieById(movieId)).thenReturn(movies)
        viewModel.movie.observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovies)
    }

    @Test
    fun getTvShow() {

        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        `when`(catalogueRepository.getTvShowById(tvShowId)).thenReturn(tvShow)
        viewModel.tvShow.observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }

    @Test
    fun setTvShowFavorite() {

        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        `when`(catalogueRepository.getTvShowById(tvShowId)).thenReturn(tvShow)
        val tvShowSelected = catalogueRepository.getTvShowById(tvShowId).value as TvShowEntity
        viewModel.tvShow.observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
        viewModel.setTvShowFavorite()
        verify(catalogueRepository).setTvShowFavorite(tvShowSelected, true)
        viewModel.tvShow.observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)


    }

    @Test
    fun setMovieFavorite() {

        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovies

        `when`(catalogueRepository.getMovieById(movieId)).thenReturn(movie)
        val movieSelected = catalogueRepository.getMovieById(movieId).value as MovieEntity
        viewModel.movie.observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovies)
        viewModel.setMovieFavorite()
        verify(catalogueRepository).setMovieFavorite(movieSelected, true)
        viewModel.movie.observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovies)


    }



}





