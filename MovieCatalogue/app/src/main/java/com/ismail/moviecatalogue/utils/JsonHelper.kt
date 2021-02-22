package com.ismail.moviecatalogue.utils

import android.content.Context
import com.ismail.moviecatalogue.data.source.remote.response.MovieResponse
import com.ismail.moviecatalogue.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movie")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val rating = movie.getString("rating")
                val duration = movie.getString("duration")
                val date = movie.getString("date")
                val genre = movie.getString("genre")
                val director = movie.getString("director")
                val description = movie.getString("description")
                val poster = movie.getString("poster")
                val movieResponse = MovieResponse(id, title, rating, duration, date, genre, director, description, poster)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvShows(): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowResponses.json").toString())
            val listArray = responseObject.getJSONArray("tv_show")
            for (i in 0 until listArray.length()) {

                val tvShow = listArray.getJSONObject(i)

                val id = tvShow.getString("id")
                val title = tvShow.getString("title")
                val rating = tvShow.getString("rating")
                val duration = tvShow.getString("duration")
                val date = tvShow.getString("date")
                val genre = tvShow.getString("genre")
                val director = tvShow.getString("director")
                val description = tvShow.getString("description")
                val poster = tvShow.getString("poster")

                val tvShowResponse = TvShowResponse(id, title, rating, duration, date, genre, director, description, poster)
                list.add(tvShowResponse)            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }
}