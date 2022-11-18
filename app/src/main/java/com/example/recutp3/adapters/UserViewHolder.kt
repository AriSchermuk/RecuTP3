package com.example.recutp3.adapters

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recutp3.R
import com.example.recutp3.fragments.UserListFragmentDirections
import com.example.recutp3.entities.User
import com.example.recutp3.utils.withFlagEmoji
import com.example.recutp3.utils.withGenderEmoji
import java.util.*

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameLabel: TextView = itemView.findViewById(R.id.lblUserItemName)
    private val nationalityLabel: TextView = itemView.findViewById(R.id.lblUserItemNationality)
    private val genderLabel: TextView = itemView.findViewById(R.id.lblUserItemGender)
    private val pictureView: ImageView = itemView.findViewById(R.id.imgUserItemPicture)
    private val userDetailsButton: Button = itemView.findViewById(R.id.btnUserDetail)

    fun bind(user: User) {
        Glide.with(itemView)
            .load(user.profilePicture)
            .into(pictureView)

        nameLabel.text = user.name

        nationalityLabel.text = user.nationality?.withFlagEmoji()

        genderLabel.text = user.gender?.withGenderEmoji()

        userDetailsButton.setOnClickListener {
            val action =
                UserListFragmentDirections.actionUserListFragmentToUserDetailFragment(user)
            itemView.findNavController().navigate(action)
        }
    }
}