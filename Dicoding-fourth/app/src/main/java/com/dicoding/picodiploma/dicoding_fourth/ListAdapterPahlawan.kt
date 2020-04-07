package com.dicoding.picodiploma.dicoding_fourth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListAdapterPahlawan(private val listPahlawan: ArrayList<Pahlawan>) : RecyclerView.Adapter<ListAdapterPahlawan.ListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return  ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPahlawan.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val pahlawan = listPahlawan[position]

        Glide.with(holder.itemView.context)
            .load(pahlawan.foto)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgPhoto)

        holder.tvName.text = pahlawan.nama
        holder.tvDetail.text = pahlawan.detail
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item)
    }

}