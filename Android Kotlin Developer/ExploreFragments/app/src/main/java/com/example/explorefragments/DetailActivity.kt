package com.example.explorefragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.explorefragments.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var bind: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val fragToInflate = intent.getStringExtra("Frag")

        when (fragToInflate) {
        "A" -> loadFragment(DetailItemAFragment())
        "B" -> loadFragment(DetailItemBFragment())
        "C" -> loadFragment(DetailItemCFragment())
        }
    }

    private fun loadFragment(detailItemFragment: Fragment) {
        val fragmentManeger = supportFragmentManager
        val fragmentTransaction = fragmentManeger.beginTransaction()
        fragmentTransaction.add(R.id.details, detailItemFragment)
        fragmentTransaction.commit()
    }
}