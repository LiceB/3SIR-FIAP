package com.example.alicebianchinogueira_rm86850

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alicebianchinogueira_rm86850.databinding.SerieListViewBinding
import java.util.Locale

class SerieAdapter : RecyclerView.Adapter<SerieAdapter.SerieViewHolder>() {
    private val item:MutableList<SerieModel> = mutableListOf()

    class SerieViewHolder(val itemHolder:SerieListViewBinding) :
        RecyclerView.ViewHolder(itemHolder.root) {
        fun bind(item:SerieModel) {
            itemHolder.txtNome.text = item.nome
            itemHolder.txtGenero.text = item.genero

            if(item.recomendaria) {
                itemHolder.thumbIcon.setImageResource(R.drawable.thumb_up)
            } else {
                itemHolder.thumbIcon.setImageResource(R.drawable.thumb_down_icon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerieViewHolder {
        return SerieViewHolder(
            SerieListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: SerieViewHolder, position: Int) {
        holder.bind(item[position])
        holder.itemHolder.closeBtn.setOnClickListener {
            removeListItem(item[position])
        }
    }

    fun setList(newItems: List<SerieModel>) {
        item.clear()
        item.addAll(newItems)
        notifyDataSetChanged()
    }

    fun removeListItem(removed: SerieModel) {
        val removedIndex = item.indexOf(removed)
        item.remove(removed)
        notifyItemRemoved(removedIndex)
        notifyItemRangeChanged(removedIndex, item.size);
    }
}