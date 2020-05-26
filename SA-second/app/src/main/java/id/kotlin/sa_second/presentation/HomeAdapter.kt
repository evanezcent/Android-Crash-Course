package id.kotlin.sa_second.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.kotlin.sa_second.R
import id.kotlin.sa_second.data.Result
import id.kotlin.sa_second.databinding.ItemHomeBinding

class HomeAdapter(private val res : List<Result>): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_home,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.binding.apply {
            viewModel = (HomeAdapterViewModel(res[holder.adapterPosition]))
            executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return res.count()
    }

    inner class HomeViewHolder(val binding: ItemHomeBinding): RecyclerView.ViewHolder(binding.root)
}