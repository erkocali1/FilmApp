package com.alierkoc.filmlerv1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alierkoc.filmlerv1.databinding.ItemRow2Binding
import com.alierkoc.filmlerv1.model.fav.FavList
import com.bumptech.glide.Glide

class FavAdapter(private var favlist:MutableList<FavList>,var context: Context,val onItemDeleteClick: (filmId: Int) -> Unit):RecyclerView.Adapter<FavAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding:ItemRow2Binding):RecyclerView.ViewHolder(binding.root){

        fun bind (item:FavList){

            binding.filmId.text=item.id.toString()
            val url = "https://image.tmdb.org/t/p/w500/${item.backdropPath}"
            Glide.with(context)
                .load(url)
                .into(binding.posterPath)
            binding.deleteItem.setOnClickListener {
                onItemDeleteClick(item.uid)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=ItemRow2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = favlist[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return favlist.size
    }
}
