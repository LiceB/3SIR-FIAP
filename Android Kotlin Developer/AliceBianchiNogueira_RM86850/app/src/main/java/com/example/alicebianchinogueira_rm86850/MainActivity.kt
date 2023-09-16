package com.example.alicebianchinogueira_rm86850

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alicebianchinogueira_rm86850.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding
    val Serieadapter = SerieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.serieRecycler.layoutManager =
            LinearLayoutManager(this)

        bind.serieRecycler.adapter = Serieadapter

        Serieadapter.setList(
            mutableListOf(
                SerieModel(
                    "Barbie",
                    "Comédia/Drama",
                    true
                ),
                SerieModel(
                    "Riverdale",
                    "Comédia/Drama",
                    true
                ),
                SerieModel(
                    "Only Murders in the Building",
                    "Comédia/Drama",
                    true
                ),
                SerieModel(
                    "Baby driver",
                    "Ação/Drama",
                    false
                )
            )
        )
    }
}