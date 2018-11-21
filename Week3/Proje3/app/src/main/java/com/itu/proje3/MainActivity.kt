package com.itu.proje3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(),connectionInterface {
    override fun onSuccess(result: String) {
        val adviceToWrite = JsonOperations.returnObjFromStr(result)
        textView.text = adviceToWrite.slips[1].advice
    }

    override fun onError(errorStr: String) {
        Log.e("Internet Call Failed",errorStr)
    }

    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button3)
        textView = findViewById(R.id.textView8)

        button.setOnClickListener { buttonClickedSearch() }

    }

    private fun buttonClickedSearch(){
        val toSearch:String = editText.text.toString()
        HttpGet(this).execute(toSearch)
    }
}
