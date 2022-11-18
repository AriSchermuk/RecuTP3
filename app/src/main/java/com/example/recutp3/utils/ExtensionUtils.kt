package com.example.recutp3.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.util.*


fun ImageView.show(view: View, url: String) {
    Glide.with(view).load(url).into(this)
}

fun String.withFlagEmoji(): String {
    // 1. It first checks if the string consists of only 2 characters: ISO 3166-1 alpha-2 two-letter country codes (https://en.wikipedia.org/wiki/Regional_Indicator_Symbol).
    val countryCode = if (this.length == 2) this else Locale.getISOCountries().find {
        Locale("EN", it).displayCountry == this;
    }

    if (countryCode?.length != 2) {
        return this
    }

    val countryCodeCaps =
        countryCode.uppercase(Locale.ROOT) // upper case is important because we are calculating offset
    val firstLetter = Character.codePointAt(countryCodeCaps, 0) - 0x41 + 0x1F1E6
    val secondLetter = Character.codePointAt(countryCodeCaps, 1) - 0x41 + 0x1F1E6

    // 2. It then checks if both characters are alphabet
    if (!countryCodeCaps[0].isLetter() || !countryCodeCaps[1].isLetter()) {
        return this
    }

    val flagEmoji =
        String(Character.toChars(firstLetter)) + String(Character.toChars(secondLetter))
    return "$this $flagEmoji"
}

fun String.withGenderEmoji(): String {
    if ("MALE" == this.uppercase()) return "$this \u2642\uFE0F"
    if ("FEMALE" == this.uppercase()) return "$this \u2640️️️️\uFE0F"
    return this
}

class ExtensionUtils {
}