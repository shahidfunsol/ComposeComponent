package com.gulehri.pakistan.lanaguage

import androidx.annotation.Keep

@Keep
data class Language(
    val countryCode: String,
    val languageName: String,
    val languageCode: String = "en",
    val flag: String
)