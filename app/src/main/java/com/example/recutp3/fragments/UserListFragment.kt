package com.example.recutp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.recutp3.R
import com.example.recutp3.entities.User

class UserListFragment : Fragment() {
    lateinit var view1: View
    lateinit var txtUserId: EditText
    lateinit var btnUserDetails: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_user_list, container, false)

        txtUserId = view1.findViewById(R.id.txtUserListUserId)
        btnUserDetails = view1.findViewById(R.id.btnUserDetail)

        return view1
    }

    override fun onStart() {
        super.onStart()
        btnUserDetails.setOnClickListener {
            if (!txtUserId.text.isNullOrEmpty()) {
                val userId = txtUserId.text.toString()
                val action =
                    UserListFragmentDirections.actionUserListFragmentToUserDetailFragment(User(userId))
                view1.findNavController().navigate(action)
            }
        }
    }
}