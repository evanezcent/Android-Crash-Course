package id.kotlin.sa_second.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.kotlin.sa_second.R
import id.kotlin.sa_second.data.Result
import kotlinx.android.synthetic.main.item_home.view.*

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
        fun bind(res: Result){
            with(itemView){
                tv_item_title.text = res.title
                tv_item_overview.text = res.overview
            }
        }
    }
}