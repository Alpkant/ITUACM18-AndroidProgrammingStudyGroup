package com.itu.ituacmw3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), ConnectionInterface {

    private lateinit var editText:EditText
    private lateinit var searchButton: Button
    private lateinit var reSearchButton:Button
    private lateinit var searchContainer:LinearLayout
    private lateinit var resultContainer: LinearLayout
    private lateinit var searchedText:TextView
    private lateinit var resultTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.edit_text_search)
        searchButton = findViewById(R.id.button_search)
        reSearchButton = findViewById(R.id.research_button)
        resultContainer = findViewById(R.id.result_container)
        searchContainer = findViewById(R.id.search_container)
        searchedText = findViewById(R.id.searched_string)
        resultTextView = findViewById(R.id.result_string)

        searchButton.setOnClickListener { searchAPI() }
        reSearchButton.setOnClickListener { openSearchContainer() }

    }

    private fun searchAPI(){
        val searchString = editText.text.toString()
        HttpGet(RequestMethods.GET,this).execute(searchString)
        openResultContainer()
    }

    private fun openResultContainer(){
        searchContainer.visibility = View.GONE
        resultContainer.visibility = View.VISIBLE
    }
    private fun openSearchContainer(){
        searchContainer.visibility = View.VISIBLE
        resultContainer.visibility = View.GONE
    }

    override fun onSuccess(result: String) {
        Log.e("Result",result)
        JSONoperations.returnObjFromString(result)
    }

    override fun onError(errorString: String) {
        Log.e("Result",errorString)
    }

}
