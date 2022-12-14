package com.example.recutp3.fragments

import android.graphics.Color
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
import com.example.recutp3.database.entities.Favorite
import com.example.recutp3.database.repository.FavoriteRepository
import com.example.recutp3.session.LoggedUserSession
import com.example.recutp3.utils.show
import com.example.recutp3.utils.withFlagEmoji
import com.example.recutp3.utils.withGenderEmoji
import com.google.android.material.floatingactionbutton.FloatingActionButton

class UserDetailFragment : Fragment() {

    lateinit var favoriteRepository: FavoriteRepository
    lateinit var view1: View
    lateinit var nameLabel: TextView
    lateinit var fromLabel: TextView
    lateinit var genderLabel: TextView
    lateinit var pictureView: ImageView
    lateinit var favoriteButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        context?.let { favoriteRepository = FavoriteRepository.getInstance(it) }

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
        val name = user.name
        nameLabel.text = getString(R.string.full_name, name.first, name.last)
        val location = user.location
        fromLabel.text = getString(
            R.string.user_detail_from,
            location.country.withFlagEmoji(),
            location.state,
            location.city
        )
        genderLabel.text = getString(R.string.user_detail_gender, user.gender.withGenderEmoji())
        pictureView.show(view1, user.picture.large)
        val loggedUserId = LoggedUserSession.loggedUser?.id ?: 0
        if (favoriteRepository.exists(
                loggedUserId,
                user.index
            )
        ) disableButton()
        favoriteButton.setOnClickListener {
            disableButton()
            favoriteRepository.add(
                Favorite(
                    0,
                    loggedUserId,
                    user.index
                )
            )
        }
    }

    private fun disableButton() {
        favoriteButton.isEnabled = false
        favoriteButton.isClickable = false
        favoriteButton.alpha = 0.5f
    }
}