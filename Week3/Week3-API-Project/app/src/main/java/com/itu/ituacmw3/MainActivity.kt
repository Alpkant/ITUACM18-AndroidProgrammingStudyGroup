package com.itu.ituacmw3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.gson.Gson
import com.itu.ituacmw3.Models.GsonAdvice
import java.lang.Exception

class MainActivity : AppCompatActivity(), ConnectionInterface {

    private lateinit var editText:EditText
    private lateinit var searchButton: Button
    private lateinit var reSearchButton:Button
    private lateinit var searchContainer:LinearLayout
    private lateinit var resultContainer: RelativeLayout
    private lateinit var resultList:ListView
    private lateinit var searchedText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.edit_text_search)
        searchButton = findViewById(R.id.button_search)
        reSearchButton = findViewById(R.id.research_button)
        resultContainer = findViewById(R.id.result_container)
        searchContainer = findViewById(R.id.search_container)
        searchedText = findViewById(R.id.searched_text)
        resultList = findViewById(R.id.result_list)

        searchButton.setOnClickListener { searchAPI() }
        reSearchButton.setOnClickListener { openSearchContainer() }

    }

    private fun searchAPI(){
        val searchString = editText.text.toString()
        searchedText.text = searchString
        HttpGet(RequestMethods.GET,this).execute(searchString)
        openResultContainer()
    }

    private fun openResultContainer(){
        searchContainer.visibility = View.INVISIBLE
        resultContainer.visibility = View.VISIBLE

    }
    private fun openSearchContainer(){
        searchContainer.visibility = View.VISIBLE
        resultContainer.visibility = View.INVISIBLE
    }

    override fun onSuccess(result: String) {
        Log.e("Result",result)
        val wantGson = true

        if(wantGson){
            val gson = Gson()
            try{
                val GsonAdvice = gson.fromJson(result,GsonAdvice::class.java)
                val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, GsonAdvice.getAdviceList())
                resultList.adapter = adapter
            }catch( e:Exception ){
                Log.e("Gson Convert","There is no advice")
            }

        }else{
            val advice = JSONoperations.returnObjFromString(result)
            val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,advice.arrayOfSlips())
            resultList.adapter = adapter
        }
    }

    override fun onError(errorString: String) {
        Log.e("Result",errorString)
    }

}
