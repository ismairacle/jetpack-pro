package com.ismail.moviecatalogue.ui.favorite.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ismail.moviecatalogue.R
import com.ismail.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.ismail.moviecatalogue.databinding.ItemsListBinding
import com.ismail.moviecatalogue.ui.detail.DetailActivity

class FavoriteMovieAdapter : PagedListAdapter<MovieEntity, FavoriteMovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private const val RADIUS = 20

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsAcademyBinding = ItemsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsAcademyBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }



    class MovieViewHolder(private val binding: ItemsListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemDate.text = movie.date
                tvItemRating.text = movie.rating
                tvItemGenre.text = movie.genre
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movie.id)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                        .load(movie.poster)
                        .transform(RoundedCorners(RADIUS))
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgPoster)
            }
        }
    }


}
