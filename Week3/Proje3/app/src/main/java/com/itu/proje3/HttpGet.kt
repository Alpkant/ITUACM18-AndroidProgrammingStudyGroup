package com.itu.proje3

import android.os.AsyncTask
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class HttpGet(private var connectInterface: connectionInterface) : AsyncTask<String,Void,String?>() {

    private var base_url = "https://api.adviceslip.com/advice/search/"
    override fun doInBackground(vararg p0: String?): String? {
        var toRet:String? = null
        var url = URL(base_url + p0[0])

        var connection = url.openConnection() as HttpURLConnection
        connection.readTimeout =  3 * 1000
        connection.connectTimeout =  5 * 1000
        connection.requestMethod = "GET"
        connection.connect()

        if (connection.responseCode == HttpURLConnection.HTTP_OK){
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
            toRet = stringBuilder.toString()
        }
        else{
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
            toRet = stringBuilder.toString()
        }
        return toRet
    }

    override fun onPostExecute(result: String?) {
        result?.let {
            connectInterface.onSuccess(result)
        }

    }
}