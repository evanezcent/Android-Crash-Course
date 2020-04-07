package com.dicoding.mygitub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.mygitub.Model.Akun
import com.dicoding.mygitub.Model.Repo

class CardAdapter(
    private val listRepo:List<Repo>
) : RecyclerView.Adapter<CardAdapter.CardHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.home_view, parent,false)
        return CardHolder(view)
    }

    override fun getItemCount(): Int {
        return listRepo.size
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val repo = listRepo[position]

        Glide.with(holder.itemView.context)
            .load(repo.owner.fotoProfil)
            .apply(RequestOptions().override(150,150))
            .into(holder.avatar)

        holder.tvRepo.text = repo.nama_repo
        holder.tvBahasa.text = repo.bahasa
    }

    inner class CardHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvRepo : TextView = itemView.findViewById(R.id.tv_repo)
        var tvBahasa : TextView = itemView.findViewById(R.id.tv_bahasa)
        var avatar : ImageView = itemView.findViewById(R.id.ci_avatar)
    }
}