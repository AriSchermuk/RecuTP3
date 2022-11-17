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

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameLabel: TextView = itemView.findViewById(R.id.lblUserItemName)
    private val nationalityLabel: TextView = itemView.findViewById(R.id.lblUserItemNationality)
    private val genderLabel: TextView = itemView.findViewById(R.id.lblUserItemGender)
    private val pictureView: ImageView = itemView.findViewById(R.id.imgUserItemPicture)
    private val userDetailsButton: Button = itemView.findViewById(R.id.btnUserDetail)

    fun bind(user : UserModel) {
        nameLabel.text = user.name
        nationalityLabel.text = user.nationality
        genderLabel.text=  user.gender
        userDetailsButton.setOnClickListener {
            val action = UserListFragmentDirections.actionUserListFragmentToUserDetailFragment(User(user.userId))
            itemView.findNavController().navigate(action)
        }
    }
}