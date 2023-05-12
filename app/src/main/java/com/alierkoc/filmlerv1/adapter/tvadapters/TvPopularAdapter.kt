package com.alierkoc.filmlerv1.adapter.tvadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alierkoc.filmlerv1.adapter.moveiadapters.MovieAdapter
import com.alierkoc.filmlerv1.databinding.ItemRowBinding
import com.alierkoc.filmlerv1.model.tvPopular.TvPopular
import com.alierkoc.filmlerv1.model.tvPopular.TvResult

class TvPopularAdapter(private val tvList:List<TvResult>,val context: Context,val onTvClickListener:(item:TvResult)->Unit):
RecyclerView.Adapter<TvPopularAdapter.ViewHolder>(){

    inner class ViewHolder(private val binding: ItemRowBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(item: TvResult){
            binding.movieId.text=item.name


        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view=ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view=tvList[position]
        holder.bind(view)
    }
    override fun getItemCount(): Int {

        return tvList.size

    }



}