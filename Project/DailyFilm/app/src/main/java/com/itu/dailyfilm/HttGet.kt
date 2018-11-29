package com.itu.dailyfilm

import android.os.AsyncTask
import android.util.Log
import com.itu.dailyfilm.Interfaces.InternetInterface
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class HttGet(val internetInterface: InternetInterface) : AsyncTask<String, Void, String>() {
    // Put your api key below with replacing <your_api_key>
    private var baseUrl ="http://www.omdbapi.com/?apikey=34048d1b"
    private val readTimeOut = 2000
    private val connectTimeOut = 2000
    private val requestMethod = "GET"


    override fun doInBackground(vararg p0: String?): String? {
        var response:String? = null
        // Concatenate ID with url.
        val urlStr = baseUrl + "&i=" + p0[0]
        val url = URL( urlStr )

        val connection = url.openConnection() as HttpURLConnection

        connection.readTimeout = readTimeOut
        connection.connectTimeout = connectTimeOut
        connection.requestMethod = requestMethod

        connection.connect()
        // Connection successful
        if (connection.responseCode == HttpURLConnection.HTTP_OK){
            // Read the result
            val streamReader = InputStreamReader(connection.inputStream)
            val bufferedReader = BufferedReader(streamReader)
            val stringBuilder = StringBuilder()
            var line:String? = bufferedReader.readLine()
            while(line != null){ // Create result from buffer
                stringBuilder.append(line).append('\n')
                line = bufferedReader.readLine()
            }
            bufferedReader.close()
            streamReader.close()
            response = stringBuilder.toString()
        }
        // Connection Failed
        else{
            var errorStr = ""
            // Read error message but only print it to log.
            val streamReader = InputStreamReader(connection.errorStream)
            val bufferedReader = BufferedReader(streamReader)
            val stringBuilder = StringBuilder()
            var line:String? = bufferedReader.readLine()
            while(line != null){ // Create result from buffer
                stringBuilder.append(line).append('\n')
                line = bufferedReader.readLine()
            }
            bufferedReader.close()
            streamReader.close()
            errorStr = stringBuilder.toString()
            Log.e("Internet Error:",errorStr)
        }
        connection.disconnect()

        return response
    }

    override fun onPostExecute(response: String?) {
        if(response != null){
            internetInterface.onSuccess(response)
        }
        else{
            internetInterface.onError()
        }
    }
}

