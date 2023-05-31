package com.example.stringthemes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stringthemes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bind : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.txtSecondLyric.text = getText(R.string.second_lyric)
    }
}