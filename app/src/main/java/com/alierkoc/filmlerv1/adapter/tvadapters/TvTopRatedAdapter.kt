package com.alierkoc.filmlerv1.adapter.tvadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alierkoc.filmlerv1.databinding.ItemRowBinding
import com.alierkoc.filmlerv1.model.trend.TrendResult
import com.alierkoc.filmlerv1.model.tvTopRated.TvTopRatedResult
import com.bumptech.glide.Glide

class TvTopRatedAdapter(private var topRatedList:List<TvTopRatedResult>,var context: Context,val onTvClickListener: (item: TvTopRatedResult) -> Unit ):
    RecyclerView.Adapter<TvTopRatedAdapter.ViewHolder>() {

        inner class ViewHolder(var binding: ItemRowBinding):RecyclerView.ViewHolder(binding.root){

            fun bind(item:TvTopRatedResult){
                binding.movieId.text=item.name
                val url = "https://image.tmdb.org/t/p/w500/${item.backdropPath}"
                Glide.with(context)
                    .load(url)
                    .into(binding.imageOfData)
                binding.root.setOnClickListener {
                    onTvClickListener(item)
                }

            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)

    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=topRatedList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {

        return topRatedList.size

    }


}