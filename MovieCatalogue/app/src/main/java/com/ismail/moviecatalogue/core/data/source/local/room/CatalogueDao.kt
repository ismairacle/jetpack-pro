package com.ismail.moviecatalogue.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.room.Dao
import com.ismail.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.ismail.moviecatalogue.core.data.source.local.entity.TvShowEntity

@Dao
interface CatalogueDao {

    //Movie
    @Query("SELECT * FROM movieEntities")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieEntities WHERE favorited = 1")
    fun getFavMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieEntities WHERE id = :id")
    fun getMovieById(id: String): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    //TV Show
    @Query("SELECT * FROM tvShowEntities")
    fun getTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tvShowEntities WHERE favorited = 1")
    fun getFavTvShows():  DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tvShowEntities WHERE id = :id")
    fun getTvShowById(id: String): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShows: List<TvShowEntity>)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)
}
