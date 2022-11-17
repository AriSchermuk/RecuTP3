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
import com.example.recutp3.session.LoggedUser
import com.example.recutp3.session.LoggedUserSession

class LoginFragment : Fragment() {
    lateinit var view1: View
    lateinit var txtLoginEmail: EditText
    lateinit var txtLoginPassword: EditText
    lateinit var btnLoginSubmit: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_login, container, false)

        txtLoginEmail = view1.findViewById(R.id.txtLoginEmail)
        txtLoginPassword = view1.findViewById(R.id.txtLoginPassword)
        btnLoginSubmit = view1.findViewById(R.id.btnLoginSubmit)

        return view1
    }

    override fun onStart() {
        super.onStart()

        btnLoginSubmit.setOnClickListener {
            val loggedUser = getLoggedUser()
            if (loggedUser != null) {
                LoggedUserSession.loggedUser = loggedUser
                val action = LoginFragmentDirections.actionLoginFragmentToUserListFragment()
                view1.findNavController().navigate(action)
            }
        }
    }

    private fun getLoggedUser(): LoggedUser? {
        return if (!txtLoginEmail.text.isNullOrEmpty() && !txtLoginPassword.text.isNullOrEmpty()) LoggedUser(
            "1", txtLoginEmail.text.toString()
        ) else null
    }
}