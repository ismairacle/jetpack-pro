package com.ismail.moviecatalogue.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ismail.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.ismail.moviecatalogue.core.data.source.local.entity.TvShowEntity

@Database(entities = [MovieEntity::class, TvShowEntity::class],version = 1)
abstract class CatalogueDatabase : RoomDatabase() {
    abstract fun catalogueDao(): CatalogueDao

    companion object {

        @Volatile
        private var INSTANCE: CatalogueDatabase? = null

        fun getInstance(context: Context): CatalogueDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                    CatalogueDatabase::class.java,
                    "Catalogues.db").build()
            }
    }
}