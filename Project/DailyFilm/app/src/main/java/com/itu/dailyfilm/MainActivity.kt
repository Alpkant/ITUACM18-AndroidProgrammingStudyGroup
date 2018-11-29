package com.itu.dailyfilm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.itu.dailyfilm.Interfaces.InternetInterface
import java.net.HttpURLConnection

class MainActivity : AppCompatActivity(), InternetInterface {
    override fun onError() {
        Log.e("Main Act ","Something Wrong With Internet!")
    }

    override fun onSuccess(result: String) {
        Log.e("Main Act ",result)
        val film = JSONParser.retObjectFromJSON(result)
        Log.e("Film:", film.title)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        HttGet(this).execute("tt2313197")
    }
}
