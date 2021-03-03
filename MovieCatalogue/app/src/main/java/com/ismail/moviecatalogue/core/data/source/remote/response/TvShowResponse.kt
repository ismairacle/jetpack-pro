package com.ismail.moviecatalogue.core.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowResponse(
    var id: String,
    var title: String,
    var rating: String,
    var duration: String,
    var date: String,
    var genre: String,
    var director: String,
    var description: String,
    var poster: String,
) : Parcelable