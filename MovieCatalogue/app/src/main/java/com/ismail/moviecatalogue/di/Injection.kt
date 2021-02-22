package com.ismail.moviecatalogue.di

import android.content.Context
import com.ismail.moviecatalogue.data.CatalogueRepository
import com.ismail.moviecatalogue.data.source.RemoteDataSource
import com.ismail.moviecatalogue.data.source.local.LocalDataSource
import com.ismail.moviecatalogue.data.source.local.room.CatalogueDatabase
import com.ismail.moviecatalogue.utils.AppExecutors
import com.ismail.moviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {

        val database = CatalogueDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.catalogueDao())
        val appExecutors = AppExecutors()

        return CatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}