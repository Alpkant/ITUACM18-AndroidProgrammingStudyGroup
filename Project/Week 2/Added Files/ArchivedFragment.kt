package com.itu.dailyfilm.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itu.dailyfilm.Adapters.ArchivedAdapter
import com.itu.dailyfilm.Models.Film

import com.itu.dailyfilm.R
import com.itu.dailyfilm.Models.Ratings


class ArchivedFragment : Fragment() {

    private lateinit var archivedRecycler:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_archived, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        archivedRecycler = view.findViewById(R.id.archived_recycler)
        archivedRecycler.layoutManager = LinearLayoutManager(activity)

        // Temporary data
        val filList = listOf<Film>(Film("Bohemian Rhapsody", 2018, "A chronicle of the years leading up to Queen's legendary appearance at the Live Aid (1985) concert.","2h 14 min","asdasd", mutableListOf<Ratings>()),
                Film("Forrest Gump", 1994, "The presidencies of Kennedy and Johnson, Vietnam, Watergate, and other history unfold through the perspective of an Alabama man with an IQ of 75.","2h 14 min","asdasd", mutableListOf<Ratings>()))

        archivedRecycler.adapter = ArchivedAdapter(filList)
    }

    companion object {
        fun newInstance(): ArchivedFragment {
            val fragment = ArchivedFragment()
            return fragment
        }
    }

}
