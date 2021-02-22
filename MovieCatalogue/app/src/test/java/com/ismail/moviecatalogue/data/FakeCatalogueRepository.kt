package com.ismail.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.ismail.moviecatalogue.data.source.NetworkBoundResource
import com.ismail.moviecatalogue.data.source.RemoteDataSource
import com.ismail.moviecatalogue.data.source.local.LocalDataSource
import com.ismail.moviecatalogue.data.source.local.entity.MovieEntity
import com.ismail.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ismail.moviecatalogue.data.source.remote.ApiResponse
import com.ismail.moviecatalogue.data.source.remote.response.MovieResponse
import com.ismail.moviecatalogue.data.source.remote.response.TvShowResponse
import com.ismail.moviecatalogue.utils.AppExecutors
import com.ismail.moviecatalogue.vo.Resource

class FakeCatalogueRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    CatalogueDataSource {


    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {

        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {

                    val movie = MovieEntity(
                            id = response.id,
                            title = response.title,
                            rating = response.rating,
                            duration= response.duration,
                            date = response.date,
                            genre = response.genre,
                            director = response.director,
                            description= response.description,
                            poster = response.poster,
                            favorited = false
                    )
                    movieList.add(movie)
                }

                localDataSource.insertMovies(movieList)
            }


        }.asLiveData()


    }


    override fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> {

        return object :
            NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getAllTvShows()

            public override fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in data) {

                    val movie = TvShowEntity(
                            id = response.id,
                            title = response.title,
                            rating = response.rating,
                            duration= response.duration,
                            date = response.date,
                            genre = response.genre,
                            director = response.director,
                            description= response.description,
                            poster = response.poster,
                            favorited = false
                    )
                    tvShowList.add(movie)
                }

                localDataSource.insertTvShows(tvShowList)
            }
        }.asLiveData()


    }

    override fun getMovieById(movieId: String): LiveData<MovieEntity> =
        localDataSource.getMovieById(movieId)


    override fun setMovieFavorite(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }

    override fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(1)
            .setPageSize(1)
            .build()
        return LivePagedListBuilder(localDataSource.getFavMovies(), config).build()
    }

    override fun getTvShowById(tvShowId: String): LiveData<TvShowEntity> =
        localDataSource.getTvShowById(tvShowId)

    override fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(1)
            .setPageSize(1)
            .build()
        return LivePagedListBuilder(localDataSource.getFavTvShows(), config).build()
    }

    override fun setTvShowFavorite(tvShow: TvShowEntity, state: Boolean) =
        appExecutors.diskIO().execute {
            localDataSource.setTvShowFavorite(tvShow, state)
        }
}