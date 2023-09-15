package com.example.paises

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paises.databinding.PaisListViewBinding
import java.util.Locale

class PaisItemAdapter : RecyclerView.Adapter<PaisItemAdapter.PaisesHolder>() {
    private val paises: MutableList<PaisModel> = mutableListOf()

    class PaisesHolder(val itemHolder: PaisListViewBinding) :
        RecyclerView.ViewHolder(itemHolder.root) {
        fun bind(item: PaisModel) {
            itemHolder.txtPais.text = item.pais
            itemHolder.txtContiente.text = item.continente
            itemHolder.continentView.setImageResource(
                when {
                    item.continente.lowercase(Locale.ROOT)
                        .contains("america") -> R.drawable.map_america
                    item.continente.lowercase(Locale.ROOT)
                        .contains("asia") -> R.drawable.map_asia
                    item.continente.lowercase(Locale.ROOT)
                        .contains("africa") -> R.drawable.map_africa
                    item.continente.lowercase(Locale.ROOT)
                        .contains("europa") -> R.drawable.map_europa
                    item.continente.lowercase(Locale.ROOT)
                        .contains("oceania") -> R.drawable.map_oceania
                    else -> R.drawable.map_empty
                }
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaisesHolder {
        return  PaisesHolder(
            PaisListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = paises.size

    override fun onBindViewHolder(holder: PaisesHolder, position: Int) {
        holder.bind(paises[position])
            holder.itemHolder.closeBtn.setOnClickListener {
                removeListItem(paises[position])
            }
    }

    fun setList(newItems: List<PaisModel>) {
        paises.clear()
        paises.addAll(newItems)
        notifyDataSetChanged()
    }

    fun addListItem(pais: PaisModel) {
        paises.add(pais)
        notifyItemInserted(paises.size)

    }

    fun removeListItem(removed: PaisModel) {
        val removedIndex = paises.indexOf(removed)
        paises.remove(removed)
        notifyItemRemoved(removedIndex)
        notifyItemRangeChanged(removedIndex, paises.size);
    }
}