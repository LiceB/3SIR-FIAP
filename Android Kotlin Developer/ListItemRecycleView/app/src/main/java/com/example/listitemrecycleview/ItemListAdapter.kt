package com.example.listitemrecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listitemrecycleview.databinding.ItemListaBinding

class  ItemListAdapter : RecyclerView.Adapter<ItemListAdapter.ItemListHolder>() {

    private val listaItens: MutableList<ItemModel> = mutableListOf()

    class ItemListHolder(val itemViewList: ItemListaBinding) : RecyclerView.ViewHolder(itemViewList.root){
        fun bind(item:ItemModel){
            itemViewList.txtTitulo.text = item.valor
            itemViewList.txtDetalhe.text = item.detalhe
            itemViewList.viewDetail.visibility =
                if (item.detailVisible) View.VISIBLE else View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListHolder {
        return ItemListHolder(
            ItemListaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = listaItens.size

    override fun onBindViewHolder(holder: ItemListHolder, position: Int) {
        holder.bind(listaItens[position])
        holder.itemViewList.cardView.setOnClickListener {
            listaItens[position].detailVisible = !listaItens[position].detailVisible
            notifyItemChanged(position)
        }
    }

    fun setitens(itens:MutableList<ItemModel>) {
        listaItens.clear()
        listaItens.addAll(itens)
        notifyDataSetChanged()
    }
}