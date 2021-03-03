package com.ismail.moviecatalogue.core.di

import android.content.Context
import com.ismail.moviecatalogue.core.data.CatalogueRepository
import com.ismail.moviecatalogue.core.data.source.RemoteDataSource
import com.ismail.moviecatalogue.core.data.source.local.LocalDataSource
import com.ismail.moviecatalogue.core.data.source.local.room.CatalogueDatabase
import com.ismail.moviecatalogue.core.utils.AppExecutors
import com.ismail.moviecatalogue.core.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {

        val database = CatalogueDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.catalogueDao())
        val appExecutors = AppExecutors()

        return CatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}