package com.dicoding.picodiploma.dicoding_fourth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardAdapterPahlawan(val listPahlawan: ArrayList<Pahlawan>) : RecyclerView.Adapter<CardAdapterPahlawan.CardViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_card_hero, parent, false)
        return  CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPahlawan.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val pahlawan = listPahlawan[position]
        Glide.with(holder.itemView.context)
            .load(pahlawan.foto)
            .apply(RequestOptions.overrideOf(350,350))
            .into(holder.img)

        holder.tvName.text = pahlawan.nama
        holder.tvDetail.text = pahlawan.detail

        holder.btnFav.setOnClickListener{Toast.makeText(holder.itemView.context, "Favorite : " + listPahlawan[holder.adapterPosition].nama, Toast.LENGTH_SHORT ).show()}
        holder.btnShare.setOnClickListener{Toast.makeText(holder.itemView.context, "Share : " + listPahlawan[holder.adapterPosition].nama, Toast.LENGTH_SHORT ).show()}
        holder.itemView.setOnClickListener{Toast.makeText(holder.itemView.context, "You choose : " + listPahlawan[holder.adapterPosition].nama, Toast.LENGTH_SHORT ).show()}
    }

    inner class CardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var img: ImageView = itemView.findViewById(R.id.img_item_card)
        var tvName : TextView = itemView.findViewById(R.id.tv_card_name)
        var tvDetail : TextView = itemView.findViewById(R.id.tv_card_detail)
        var btnFav : Button = itemView.findViewById(R.id.btn_favorite)
        var btnShare : Button = itemView.findViewById(R.id.btn_share)
    }

}