package com.itu.dailyfilm.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.itu.dailyfilm.Models.Film
import com.itu.dailyfilm.HttGet
import com.itu.dailyfilm.Interfaces.InternetInterface
import com.itu.dailyfilm.JSONParser
import com.itu.dailyfilm.Models.Ratings
import com.itu.dailyfilm.R

class HomePageFragment : Fragment() , InternetInterface {

    override fun onError() {}


    override fun onSuccess(result: String) {
        // Parse the film object
        val film = JSONParser.retObjectFromJSON(result)
        // Fill the views
        fillTextWithInfo(film)
    }

    private var mParam1: String? = null
    private var mParam2: String? = null

    private lateinit var titleText:TextView
    private lateinit var yearText:TextView
    private lateinit var plotText:TextView
    private lateinit var runTimeTextView: TextView

    private lateinit var ratingsListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_home_page_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialize text views
        initTextViews(view)

        HttGet(this).execute("tt2313197")
    }

    private fun initTextViews(view:View){
        // initialize text views
        titleText = view.findViewById(R.id.home_page_title_text)
        yearText = view.findViewById(R.id.home_page_year_text)
        plotText = view.findViewById(R.id.home_page_plot_text)
        runTimeTextView = view.findViewById(R.id.home_page_runtime_text)
        // initialize list view
        ratingsListView = view.findViewById(R.id.home_page_ratings_list)

    }

    // Fill the text views with film information
    private fun fillTextWithInfo(film: Film?){
        titleText.text = film?.title
        yearText.text = film?.year.toString()
        plotText.text = film?.plot
        runTimeTextView.text = film?.runtime

        film?.let {
            fillRatingsList(film)
        }

    }

    private fun fillRatingsList(film: Film){
        val curContext = context
        curContext?.let {
            val listAdapter = ArrayAdapter<Ratings>(curContext, android.R.layout.simple_list_item_1, film.ratings )
            ratingsListView.adapter = listAdapter
        }
    }

    companion object {
        fun newInstance(): HomePageFragment{
            val fragment = HomePageFragment()
            return fragment
        }
    }


}
