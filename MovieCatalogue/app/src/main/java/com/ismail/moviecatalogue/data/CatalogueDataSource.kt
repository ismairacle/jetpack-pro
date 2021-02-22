package com.ismail.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.ismail.moviecatalogue.data.source.local.entity.MovieEntity
import com.ismail.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ismail.moviecatalogue.vo.Resource

interface CatalogueDataSource {

    //Movie
    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getMovieById(movieId: String): LiveData<MovieEntity>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>>

    //TV Show
    fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getTvShowById(tvShowId: String): LiveData<TvShowEntity>

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>>

    fun setTvShowFavorite(tvShow: TvShowEntity, state: Boolean)
}
