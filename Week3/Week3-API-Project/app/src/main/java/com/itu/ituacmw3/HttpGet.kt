package com.itu.ituacmw3

import android.os.AsyncTask
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

//An asynctask takes 3 argument as <Parameters,Progress,Result>
class HttpGet(private var requestMethod:RequestMethods,private var connectionInterface: ConnectionInterface)
    : AsyncTask<String,Void,String>(){

    override fun doInBackground(vararg params: String?): String {
        var response = ""
        val readTimeOut = 20000
        val connectTimeOut = 5000
        val base_url = "https://api.adviceslip.com/advice/search/"

        try
        {
            val toSearch = params[0]

            val url = URL( base_url + toSearch )

            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = requestMethod.reqName
            connection.readTimeout = readTimeOut
            connection.connectTimeout = connectTimeOut
            connection.connect()
            // Connection successful
            if ( connection.responseCode == HttpURLConnection.HTTP_OK ) {
                // Read result
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
            else{// Connection failed.
                Log.e("Error: ",connection.responseCode.toString())
                var errorStr = ""
                // Read error message
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

                connectionInterface.onError(errorStr)
            }
            connection.disconnect()
        }
        catch (err :Exception){
            Log.e("Error",err.toString())
        }
        return response
    }

    override fun onPostExecute(result: String?) {
        result?.let{
            connectionInterface.onSuccess(result)
        }
    }
}