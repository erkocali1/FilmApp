package com.alierkoc.filmlerv1.adapter.moveiadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alierkoc.filmlerv1.databinding.ItemRowBinding
import com.alierkoc.filmlerv1.model.upComing.UpComingResult
import com.bumptech.glide.Glide

class MovieUpComingAdapter(private val upComingList:List<UpComingResult>, val context: Context, val onMovieClickListener: (item: UpComingResult) -> Unit)
    :RecyclerView.Adapter<MovieUpComingAdapter.ViewHolder>() {

        inner class ViewHolder(private val binding: ItemRowBinding):RecyclerView.ViewHolder(binding.root) {

            fun bind(item: UpComingResult){
                binding.movieId.text=item.title
                val url = "https://image.tmdb.org/t/p/w500/${item.backdropPath}"
                Glide.with(context)
                    .load(url)
                    .into(binding.imageOfData)

                binding.root.setOnClickListener {
                    onMovieClickListener(item)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view=ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(upComingList[position])

    }
    override fun getItemCount(): Int {
        return upComingList.size


    }

}