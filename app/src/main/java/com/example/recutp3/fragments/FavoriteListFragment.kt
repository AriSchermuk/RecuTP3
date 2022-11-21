package com.example.recutp3.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recutp3.R
import com.example.recutp3.adapters.UserAdapter
import com.example.recutp3.database.repository.FavoriteRepository
import com.example.recutp3.models.User
import com.example.recutp3.models.UserResults
import com.example.recutp3.services.UserServiceApiBuilder
import com.example.recutp3.session.LoggedUserSession
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class FavoriteListFragment : Fragment() {
    lateinit var view1: View
    lateinit var title: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var favoriteRepository: FavoriteRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_favorite_list, container, false)

        context?.let { favoriteRepository = FavoriteRepository.getInstance(it) }
        title = view1.findViewById(R.id.lblFavoritesTitle)
        recyclerView = view1.findViewById(R.id.recyclerViewFavoriteList)

        return view1
    }

    override fun onStart() {
        super.onStart()
        loadUsers()
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
        val loggedUser = LoggedUserSession.loggedUser
        val favoriteIndexes =
            favoriteRepository.getFavoriteIndexes(loggedUser?.id ?: "0")
        val filteredUsers = users.filterIndexed { i, _ -> favoriteIndexes.contains(i) }
        loggedUser?.email?.let {
            title.text =
                getString(R.string.favorite_list_title, it, filteredUsers.size)
        }
        recyclerView.adapter = UserAdapter(filteredUsers)
        recyclerView.layoutManager = LinearLayoutManager(parentFragment?.context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                parentFragment?.context,
                DividerItemDecoration.VERTICAL
            )
        )
    }
}