package com.ismail.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ismail.moviecatalogue.R
import com.ismail.moviecatalogue.data.source.local.entity.MovieEntity
import com.ismail.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ismail.moviecatalogue.databinding.ActivityDetailBinding
import com.ismail.moviecatalogue.databinding.ContentDetailBinding
import com.ismail.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TVSHOW = "extra_tvshow"
        private const val RADIUS = 20

    }

    private lateinit var detailContentBinding: ContentDetailBinding
    private lateinit var viewModel: DetailViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailBinding.detailContent

        setContentView(activityDetailBinding.root)

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]


        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            val tvShowId = extras.getString(EXTRA_TVSHOW)
            if (movieId != null) {
                activityDetailBinding.progressBar.visibility = View.VISIBLE
                viewModel.setSelectedMovie(movieId)
                viewModel.movie.observe(this, { movie ->
                    if (movie != null) {
                        progress_bar.visibility = View.GONE
                        populateMovie(movie)
                    }

                })
            } else {
                if (tvShowId != null) {
                    activityDetailBinding.progressBar.visibility = View.VISIBLE
                    viewModel.setSelectedTvShow(tvShowId)
                    viewModel.tvShow.observe(this, { tvShow ->
                        activityDetailBinding.progressBar.visibility = View.GONE
                        populateTvShow(tvShow)
                    })
                }


            }
        }


    }

    private fun populateTvShow(tvShowEntity: TvShowEntity) {
        detailContentBinding.textTitle.text = tvShowEntity.title
        detailContentBinding.textRating.text = tvShowEntity.rating
        detailContentBinding.textReleaseDate.text = tvShowEntity.date
        detailContentBinding.textGenre.text = tvShowEntity.genre
        detailContentBinding.textDirector.text = tvShowEntity.director
        detailContentBinding.textDescription.text = tvShowEntity.description
        detailContentBinding.textDuration.text = tvShowEntity.duration

        Glide.with(this)
                .load(tvShowEntity.poster)
                .transform(RoundedCorners(RADIUS))
                .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error)
                )
                .into(detailContentBinding.imagePoster)
    }


    private fun populateMovie(movieEntity: MovieEntity) {

        detailContentBinding.textTitle.text = movieEntity.title
        detailContentBinding.textRating.text = movieEntity.rating
        detailContentBinding.textReleaseDate.text = movieEntity.date
        detailContentBinding.textGenre.text = movieEntity.genre
        detailContentBinding.textDirector.text = movieEntity.director
        detailContentBinding.textDescription.text = movieEntity.description
        detailContentBinding.textDuration.text = movieEntity.duration
        Glide.with(this)
                .load(movieEntity.poster)
                .transform(RoundedCorners(RADIUS))
                .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error)
                )
                .into(detailContentBinding.imagePoster)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu

        viewModel.movie.observe(this, { detailMovie ->
            if (detailMovie != null) {
                val state = detailMovie.favorited
                setFavoriteState(state)
            }
        })
        viewModel.tvShow.observe(this, { detailTvShow ->
            if (detailTvShow != null) {
                val state = detailTvShow.favorited
                setFavoriteState(state)
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            viewModel.setMovieFavorite()
            viewModel.setTvShowFavorite()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_border)
        }
    }
}
