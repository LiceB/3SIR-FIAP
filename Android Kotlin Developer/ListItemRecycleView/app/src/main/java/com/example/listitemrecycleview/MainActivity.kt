package com.example.listitemrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listitemrecycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding
    val itensAdapter = ItemListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.itensRecycler.layoutManager = LinearLayoutManager(this)
        bind.itensRecycler.adapter = itensAdapter
        itensAdapter.setitens(
            mutableListOf(ItemModel("Item A", "Detalhe AAA", false),
                ItemModel("Item B", "Detalhe BBB ", false),
                ItemModel("Item C", "Detalhe CCC ", false))
        )
    }
}