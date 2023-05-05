package com.alierkoc.filmlerv1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alierkoc.filmlerv1.databinding.ItemRowBinding
import com.alierkoc.filmlerv1.model.FilmData

class MovieAdapter(var filmDataList: ArrayList<FilmData>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    class ViewHolder(private val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FilmData) {
            binding.movieId.text = item.movie_id

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view =ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmDataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(filmDataList.get(position))
    }

    fun updateFilmData(newList:List<FilmData>){

        filmDataList.clear()
        filmDataList.addAll(newList)
        notifyDataSetChanged()

    }
}



