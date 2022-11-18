package com.example.recutp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.recutp3.R
import com.example.recutp3.utils.withFlagEmoji
import com.example.recutp3.utils.withGenderEmoji

class UserDetailFragment : Fragment() {
    lateinit var view1: View
    lateinit var nameLabel: TextView
    lateinit var fromLabel: TextView
    lateinit var genderLabel: TextView
    lateinit var pictureView: ImageView
    lateinit var favoriteButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_user_detail, container, false)

        nameLabel = view1.findViewById(R.id.lblUserDetailName)
        fromLabel = view1.findViewById(R.id.lblUserDetailFrom)
        genderLabel = view1.findViewById(R.id.lblUserDetailGender)
        pictureView = view1.findViewById(R.id.imgUserDetailProfilePicture)
        favoriteButton = view1.findViewById(R.id.btnUserDetailFavorite)

        return view1
    }

    override fun onStart() {
        super.onStart()
        val user = UserDetailFragmentArgs.fromBundle(requireArguments()).user
        nameLabel.text = user.name
        fromLabel.text = getString(R.string.user_detail_from, user.nationality?.withFlagEmoji())
        genderLabel.text = getString(R.string.user_detail_gender, user.gender?.withGenderEmoji())
        Glide.with(view1).load(user.profilePicture).into(pictureView)
    }
}