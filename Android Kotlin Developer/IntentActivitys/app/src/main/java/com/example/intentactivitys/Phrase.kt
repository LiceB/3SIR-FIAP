package com.example.intents_motivation

import android.os.Parcelable
import com.example.intentactivitys.PhraseType
import kotlinx.parcelize.Parcelize

@Parcelize
data class Phrase(
    val phrase: String,
    val type: PhraseType
) : Parcelable