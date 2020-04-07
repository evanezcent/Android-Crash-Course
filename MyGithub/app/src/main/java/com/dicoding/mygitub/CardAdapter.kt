package com.dicoding.mygitub

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
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

        holder.data = repo

    }

    inner class CardHolder(itemView: View, var data: Repo ?= null): RecyclerView.ViewHolder(itemView){
        var tvRepo : TextView = itemView.findViewById(R.id.tv_repo)
        var tvBahasa : TextView = itemView.findViewById(R.id.tv_bahasa)
        var avatar : ImageView = itemView.findViewById(R.id.ci_avatar)
        var btnSee : Button = itemView.findViewById(R.id.btn_lihat)

        init {
            btnSee.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)

                intent.putExtra(DetailActivity.USERNAME, data!!.owner.username)
                intent.putExtra(DetailActivity.LINK, data!!.nama_repo)
                intent.putExtra(DetailActivity.DESCRIPTION, data!!.desc)
                intent.putExtra(DetailActivity.STAR, data!!.star)
                intent.putExtra(DetailActivity.FORK, data!!.fork)
                intent.putExtra(DetailActivity.WATCH, data!!.watch)
                intent.putExtra(DetailActivity.BITMAP, data!!.owner.fotoProfil)

                btnSee.context.startActivity(intent)
            }
        }
    }
}