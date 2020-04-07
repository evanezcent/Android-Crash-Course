package com.dicoding.picodiploma.dicoding_fourth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridAdapterPahlawan(val listPahlawan : ArrayList<Pahlawan>) : RecyclerView.Adapter<GridAdapterPahlawan.GridViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_hero, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPahlawan.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listPahlawan[position].foto)
            .apply(RequestOptions.overrideOf(350, 350))
            .into(holder.imgPhoto)
    }

    inner class GridViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_grid)
    }

}