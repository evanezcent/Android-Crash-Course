package id.kotlin.sa_second.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.kotlin.sa_second.R
import id.kotlin.sa_second.data.Result

class HomeAdapter(private val res : List<Result>): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_home,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(res[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return res.count()
    }

    inner class HomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(result: Result){
            with(itemView){
                val title = findViewById<TextView>(R.id.tv_item_title)
                title.text = result.title

                val overview = findViewById<TextView>(R.id.tv_item_overview)
                overview.text = result.overview
            }
        }
    }
}