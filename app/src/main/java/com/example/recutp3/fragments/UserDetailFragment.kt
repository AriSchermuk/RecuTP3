package com.example.recutp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.recutp3.R

class UserDetailFragment : Fragment() {
    lateinit var view1: View
    lateinit var lblDescription: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_user_detail, container, false)

        lblDescription = view1.findViewById(R.id.lblUserDetailDescription)

        return view1
    }

    override fun onStart() {
        super.onStart()
        val userId = UserDetailFragmentArgs.fromBundle(requireArguments()).userId
        lblDescription.text = getString(R.string.userDetail_description, userId)
    }
}