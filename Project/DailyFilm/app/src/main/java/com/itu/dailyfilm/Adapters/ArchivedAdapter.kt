package com.itu.dailyfilm.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.itu.dailyfilm.Models.Film
import com.itu.dailyfilm.R

class ArchivedAdapter(private var archivedFilmList:List<Film>): RecyclerView.Adapter<ArchivedAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ViewHolder {
        val itemView =  LayoutInflater.from(parent.context).inflate(R.layout.archived_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return archivedFilmList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        val currentFilm = archivedFilmList[p1]
        holder.tittleText.text = currentFilm.title
        holder.plotText.text = currentFilm.plot
    }


    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val tittleText = view.findViewById<TextView>(R.id.archived_item_title_text)
        val plotText = view.findViewById<TextView>(R.id.archived_item_plot_text)
    }
}