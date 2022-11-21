package com.example.recutp3.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recutp3.R
import com.example.recutp3.adapters.UserAdapter
import com.example.recutp3.models.User
import com.example.recutp3.models.UserResults
import com.example.recutp3.services.UserServiceApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserListFragment : Fragment() {
    lateinit var view1: View
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_user_list, container, false)

        recyclerView = view1.findViewById(R.id.recyclerViewUserList)
        loadUsers()

        return view1
    }

    private fun loadUsers() {
        val service = UserServiceApiBuilder.create()
        service.getUsersSeeded(20, "seed").enqueue(object : Callback<UserResults> {
            override fun onResponse(call: Call<UserResults>, response: Response<UserResults>) {
                if (response.isSuccessful) {
                    val userResults = response.body()
                    setupRecyclerView(userResults?.results ?: emptyList())
                }
            }

            override fun onFailure(call: Call<UserResults>, t: Throwable) {
                Log.e("Error on RandomUser call", t.stackTraceToString())
            }
        })
    }

    private fun setupRecyclerView(users: List<User>) {
        setIndexes(users)
        recyclerView.adapter = UserAdapter(users)
        recyclerView.layoutManager = LinearLayoutManager(parentFragment?.context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                parentFragment?.context,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun setIndexes(users: List<User>) {
        users.forEachIndexed { i, u ->
            run { u.index = i }
        }
    }
}