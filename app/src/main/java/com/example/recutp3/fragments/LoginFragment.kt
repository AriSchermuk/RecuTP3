package com.example.recutp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.recutp3.R
import com.example.recutp3.database.entities.AppUser
import com.example.recutp3.database.repository.AppUserRepository
import com.example.recutp3.database.repository.FavoriteRepository
import com.example.recutp3.session.LoggedUser
import com.example.recutp3.session.LoggedUserSession

class LoginFragment : Fragment() {
    lateinit var view1: View
    lateinit var txtLoginEmail: EditText
    lateinit var txtLoginPassword: EditText
    lateinit var btnLoginSubmit: Button
    lateinit var btnLoginRegister: Button
    lateinit var lblLoginError: TextView
    lateinit var appUserRepository: AppUserRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_login, container, false)

        txtLoginEmail = view1.findViewById(R.id.txtLoginEmail)
        txtLoginPassword = view1.findViewById(R.id.txtLoginPassword)
        btnLoginSubmit = view1.findViewById(R.id.btnLoginSubmit)
        btnLoginRegister = view1.findViewById(R.id.btnRegister)
        lblLoginError = view1.findViewById(R.id.lblLoginError)
        context?.let { appUserRepository = AppUserRepository.getInstance(it) }

        return view1
    }

    override fun onStart() {
        super.onStart()

        val previouslyLoggedUser = appUserRepository.findLoggedUser()
        if (previouslyLoggedUser != null) {
            LoggedUserSession.loggedUser = previouslyLoggedUser
            val action = LoginFragmentDirections.actionLoginFragmentToUserListFragment()
            view1.findNavController().navigate(action)
        }


        btnLoginSubmit.setOnClickListener {
            val loggedUser = getLoggedUser()
            if (loggedUser != null) {
                loggedUser.logged = true
                appUserRepository.updateUser(loggedUser)
                LoggedUserSession.loggedUser = loggedUser
                val action = LoginFragmentDirections.actionLoginFragmentToUserListFragment()
                view1.findNavController().navigate(action)
                lblLoginError.text = ""
            } else {
                lblLoginError.text = getString(R.string.user_not_found)
            }
        }
        btnLoginRegister.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            view1.findNavController().navigate(action)
        }
    }

    private fun getLoggedUser(): AppUser? {
        return appUserRepository.get(
            txtLoginEmail.text.toString(),
            txtLoginPassword.text.toString()
        )
    }
}