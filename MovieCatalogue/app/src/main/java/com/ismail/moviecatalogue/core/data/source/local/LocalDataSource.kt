package com.ismail.moviecatalogue.core.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.ismail.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.ismail.moviecatalogue.core.data.source.local.entity.TvShowEntity
import com.ismail.moviecatalogue.core.data.source.local.room.CatalogueDao

class LocalDataSource private constructor(private val mcatalogueDao: CatalogueDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(catalogueDao: CatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(catalogueDao)
    }

    //Movie
    fun getMovies(): DataSource.Factory<Int, MovieEntity> = mcatalogueDao.getMovies()

    fun getFavMovies(): DataSource.Factory<Int, MovieEntity> = mcatalogueDao.getFavMovie()

    fun insertMovies(movies: List<MovieEntity>) = mcatalogueDao.insertMovies(movies)

    fun getMovieById(id: String): LiveData<MovieEntity> = mcatalogueDao.getMovieById(id)

    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.favorited = newState
        mcatalogueDao.updateMovie(movie)
    }

    //TV Show
    fun getTvShowById(id: String): LiveData<TvShowEntity> = mcatalogueDao.getTvShowById(id)

    fun getTvShows(): DataSource.Factory<Int, TvShowEntity> = mcatalogueDao.getTvShows()

    fun getFavTvShows(): DataSource.Factory<Int, TvShowEntity> = mcatalogueDao.getFavTvShows()

    fun insertTvShows(tvShows: List<TvShowEntity>) = mcatalogueDao.insertTvShow(tvShows)

    fun setTvShowFavorite(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.favorited = newState
        mcatalogueDao.updateTvShow(tvShow)
    }


}