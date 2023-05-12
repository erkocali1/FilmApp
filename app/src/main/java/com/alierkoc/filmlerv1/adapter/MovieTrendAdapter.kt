package com.alierkoc.filmlerv1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alierkoc.filmlerv1.databinding.ItemRowBinding
import com.alierkoc.filmlerv1.model.TrendResult
import com.bumptech.glide.Glide

data class MovieTrendAdapter(var trendList:List<TrendResult>,var context: Context)
    :RecyclerView.Adapter<MovieTrendAdapter.ViewHolder>() {

        inner class ViewHolder(private val binding:ItemRowBinding):RecyclerView.ViewHolder(binding.root){

            fun bind(item:TrendResult){
                binding.movieId.text=item.title
                val url = "https://image.tmdb.org/t/p/w500/${item.backdropPath}"
                Glide.with(context)
                    .load(url)
                    .into(binding.imageOfData)
            }

        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(trendList[position])

    }
    override fun getItemCount(): Int {

        return trendList.size

    }
}