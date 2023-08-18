package com.gulehri.pakistan.lanaguage

import com.gulehri.pakistan.lanaguage.CountryFlags.getCountryFlag


val LANGUAGES_LIST by lazy {
    listOf(
        Language("sa", "Arabic (عربي)", "ar", getCountryFlag("sa")),
        Language("gb", "English", "en", getCountryFlag("gb")),
        Language("ru", "Russian  (Русский)", "ru", getCountryFlag("ru")),
        Language("id", "Indonesian (Bahasa Indonesia)", "in", getCountryFlag("id")),
        Language("bd", "Bengali (বাংলা)", "bn", getCountryFlag("bd")),
        Language("in", "Hindi  (हिंदी)", "hi", getCountryFlag("in")),
        Language("ua", "Ukrainian (українська)", "uk", getCountryFlag("ua")),
        Language("vn", "Vietnamese (Tiếng Việt)", "vi", getCountryFlag("vn")),
        Language("kp", "Korean (한국인)", "ko", getCountryFlag("kp")),
        Language("jp", "Japanese (日本)", "ja", getCountryFlag("jp")),
        Language("cn", "Chinese (中国人)", "zh", getCountryFlag("cn")),
        Language("sv", "Swedish (svenska)", "sv", getCountryFlag("sv")),
        Language("pl", "Polish (Polski)", "pl", getCountryFlag("pl")),
        Language("fr", "French (Français)", "fr", getCountryFlag("fr")),
        Language("it", "Italian (Italiano)", "it", getCountryFlag("it")),
        Language("ir", "Persian (فارسی)", "fa", getCountryFlag("ir")),
        Language("tr", "Turkish (Türkçe)", "tr", getCountryFlag("tr")),
        Language("th", "Thai (แบบไทย)", "th", getCountryFlag("th")),
        Language("pt", "Portuguese (Português)", "pt", getCountryFlag("pt")),
        Language("es", "Spanish (Español)", "es", getCountryFlag("es")),
        Language("de", "German (Deutsch)", "de", getCountryFlag("de")),
        Language("nl", "Dutch (Nederlands)", "nl", getCountryFlag("nl")),
        Language("pk", "Urdu (اردو)", "ur", getCountryFlag("pk")),
        Language("in", "Tamil (தமிழ்)", "ta", getCountryFlag("in"))
    ).sortedBy { it.languageName.substringBefore(" (") }
}

