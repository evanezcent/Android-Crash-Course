package id.kotlin.sa_first

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DetailAdapter: RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_detail,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int {
        return 7
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind()
    }


    inner class DetailViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(){
            with(itemView){
                val detailText = findViewById<TextView>(R.id.tv_detail)
                val text = "Ini RecyclerView  $adapterPosition"
                detailText.text = text
            }
        }
    }
}