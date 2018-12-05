package com.itu.dailyfilm.Fragments


import android.os.Bundle
import android.os.Message
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itu.dailyfilm.Adapters.ChatAdapter
import com.itu.dailyfilm.Models.ChatItem

import com.itu.dailyfilm.R


class ChatFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.chat_recycler)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        // Below code is temporary. Placeholder
        val chatList  = listOf<ChatItem>(ChatItem("Burak",1543923780, "ITU ACM",false),
        ChatItem("Burak",1543923280, "Android",false),
        ChatItem("ACM",1543923680, "Kotlin",true),
        ChatItem("Burak",1543913780, "ITU ACM",false),
        ChatItem("ACM",1543924780, "ITU ACM",true))

        // Load the recycler with the data
        recyclerView.adapter = ChatAdapter(chatList)
    }

    companion object {
        fun newInstance(): ChatFragment {
            val fragment = ChatFragment()
            return fragment
        }
    }

}// Required empty public constructor
