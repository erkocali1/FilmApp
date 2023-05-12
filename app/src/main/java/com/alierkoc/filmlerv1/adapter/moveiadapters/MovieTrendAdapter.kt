package com.alierkoc.filmlerv1.adapter.moveiadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alierkoc.filmlerv1.databinding.ItemRowBinding
import com.alierkoc.filmlerv1.model.trend.TrendResult
import com.bumptech.glide.Glide

 class MovieTrendAdapter(var trendList:List<TrendResult>, var context: Context, val onMovieClickListener: (item: TrendResult) -> Unit)
    :RecyclerView.Adapter<MovieTrendAdapter.ViewHolder>() {

        inner class ViewHolder(private val binding:ItemRowBinding):RecyclerView.ViewHolder(binding.root){

            fun bind(item: TrendResult){
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

        val item=trendList[position]
        holder.bind(item)

    }
    override fun getItemCount(): Int {

        return trendList.size

    }
}