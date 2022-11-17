package com.example.recutp3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recutp3.R
import com.example.recutp3.adapters.UserAdapter
import com.example.recutp3.mocks.UserMock

class UserListFragment : Fragment() {
    lateinit var view1: View
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_user_list, container, false)

        val users = UserMock().userMock()

        recyclerView = view1.findViewById(R.id.reciclerViewUserList)
        recyclerView.adapter = UserAdapter(users)
        recyclerView.layoutManager = LinearLayoutManager(parentFragment?.context)

        return view1
    }
}