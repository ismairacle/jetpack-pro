package com.ismail.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.ismail.moviecatalogue.core.data.source.RemoteDataSource
import com.ismail.moviecatalogue.core.data.source.local.LocalDataSource
import com.ismail.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.ismail.moviecatalogue.core.data.source.local.entity.TvShowEntity
import com.ismail.moviecatalogue.ui.utils.PagedListUtil
import com.ismail.moviecatalogue.core.utils.AppExecutors
import com.ismail.moviecatalogue.core.utils.DataDummy
import com.ismail.moviecatalogue.core.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


class CatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val catalogueRepository = FakeCatalogueRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()

    private val tvShowResponses = DataDummy.generateRemoteDummyTvShow()


    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovies()).thenReturn(dataSourceFactory)
        catalogueRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getMovies()
        assertNotNull(movieEntities)
        movieEntities.data?.size?.let { assertEquals(movieResponses.size.toLong(), it.toLong()) }
    }

    @Test
    fun getAllTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShows()).thenReturn(dataSourceFactory)
        catalogueRepository.getAllTvShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getTvShows()
        assertNotNull(tvShowEntities)
        tvShowEntities.data?.size?.let { assertEquals(tvShowResponses.size.toLong(), it.toLong()) }
    }

    @Test
    fun getFavoritedMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavMovies()).thenReturn(dataSourceFactory)
        catalogueRepository.getFavoriteMovies()
        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }
    @Test
    fun getFavoritedTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavTvShows()).thenReturn(dataSourceFactory)
        catalogueRepository.getFavoriteTvShows()
        val tvShowEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getFavTvShows()
        assertNotNull(tvShowEntity)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntity.data?.size?.toLong())
    }




}