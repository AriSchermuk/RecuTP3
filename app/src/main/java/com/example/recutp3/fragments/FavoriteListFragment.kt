package com.example.recutp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recutp3.R
import com.example.recutp3.database.repository.FavoriteRepository

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
}