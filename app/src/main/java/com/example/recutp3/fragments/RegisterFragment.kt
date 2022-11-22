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
import com.example.recutp3.R
import com.example.recutp3.database.entities.AppUser
import com.example.recutp3.database.repository.AppUserRepository

class RegisterFragment : Fragment() {
    lateinit var view1: View
    lateinit var txtRegisterEmail: EditText
    lateinit var txtRegisterPassword: EditText
    lateinit var btnRegisterSubmit: Button
    lateinit var lblRegisterError: TextView
    lateinit var appUserRepository: AppUserRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_register, container, false)

        txtRegisterEmail = view1.findViewById(R.id.txtRegisterEmail)
        txtRegisterPassword = view1.findViewById(R.id.txtRegisterPassword)
        btnRegisterSubmit = view1.findViewById(R.id.btnRegisterSubmit)
        lblRegisterError = view1.findViewById(R.id.lblRegisterError)
        context?.let { appUserRepository = AppUserRepository.getInstance(it) }

        return view1
    }

    override fun onStart() {
        super.onStart()

        btnRegisterSubmit.setOnClickListener {
            val email = txtRegisterEmail.text.toString()
            val password = txtRegisterPassword.text.toString()
            if (validCredentials(email, password)) {
                appUserRepository.add(
                    AppUser(
                        0,
                        email,
                        password
                    )
                )
                lblRegisterError.text = ""
                val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
                view1.findNavController().navigate(action)
            }
        }
    }

    private fun validCredentials(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            lblRegisterError.text = getString(R.string.email_mandatory_error)
            return false
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            lblRegisterError.text = getString(R.string.invalid_email_error)
            return false
        }
        if (password.isEmpty()) {
            lblRegisterError.text = getString(R.string.password_mandatory_error)
            return true
        }

        return true
    }
}