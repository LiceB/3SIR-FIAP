package com.example.paises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.paises.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IAddPais {

    lateinit var bind: ActivityMainBinding
    val itensAdapter = PaisItemAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.paisesRecycler.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        itensAdapter.setList(mutableListOf(
            PaisModel("Brasil", "America do Sul"),
            PaisModel("Australia", "Oceania"),
            PaisModel("China", "Asia"),
            PaisModel("Egito", "Africa"),
            PaisModel("Portugal", "Europa")
        ))

        bind.btnAdd.setOnClickListener {
            AddDialogFragment.newInstance(this).show(supportFragmentManager, "ADD_DIALOG")
        }
    }

    override fun addPais(paisModel: PaisModel) {
        itensAdapter.addListItem(paisModel)
    }
}