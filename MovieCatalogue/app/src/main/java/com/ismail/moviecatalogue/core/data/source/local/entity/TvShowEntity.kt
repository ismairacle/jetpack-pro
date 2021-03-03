package com.ismail.moviecatalogue.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvShowEntities")
data class TvShowEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        var id: String,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "rating")
        var rating: String,

        @ColumnInfo(name = "duration")
        var duration: String,

        @ColumnInfo(name = "date")
        var date: String,

        @ColumnInfo(name = "genre")
        var genre: String,

        @ColumnInfo(name = "director")
        var director: String,

        @ColumnInfo(name = "description")
        var description: String,

        @ColumnInfo(name = "poster")
        var poster: String,

        @ColumnInfo(name = "favorited")
        var favorited: Boolean
)