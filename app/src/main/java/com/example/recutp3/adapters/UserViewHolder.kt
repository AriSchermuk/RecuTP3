package com.example.recutp3.adapters

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.recutp3.R
import com.example.recutp3.entities.User
import com.example.recutp3.fragments.UserListFragmentDirections
import com.example.recutp3.models.UserModel
import java.util.*

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameLabel: TextView = itemView.findViewById(R.id.lblUserItemName)
    private val nationalityLabel: TextView = itemView.findViewById(R.id.lblUserItemNationality)
    private val genderLabel: TextView = itemView.findViewById(R.id.lblUserItemGender)
    private val pictureView: ImageView = itemView.findViewById(R.id.imgUserItemPicture)
    private val userDetailsButton: Button = itemView.findViewById(R.id.btnUserDetail)

    fun bind(user: UserModel) {
        nameLabel.text = user.name
        nationalityLabel.text = user.nationality.withFlagEmoji()
        genderLabel.text = user.gender.withGenderEmoji()
        userDetailsButton.setOnClickListener {
            val action =
                UserListFragmentDirections.actionUserListFragmentToUserDetailFragment(User(user.userId))
            itemView.findNavController().navigate(action)
        }
    }

    fun String.withFlagEmoji(): String {
        // 1. It first checks if the string consists of only 2 characters: ISO 3166-1 alpha-2 two-letter country codes (https://en.wikipedia.org/wiki/Regional_Indicator_Symbol).
        if (this.length != 2) {
            return this
        }

        val countryCodeCaps =
            this.uppercase(Locale.ROOT) // upper case is important because we are calculating offset
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
        if ("Male".equals(this)) return "$this \u2642\uFE0F"
        if ("Female".equals(this)) return "$this \u2640️️️️\uFE0F"
        return this
    }
}