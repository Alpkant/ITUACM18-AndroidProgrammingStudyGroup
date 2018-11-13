package com.itu.ituacmw3

import com.itu.ituacmw3.Models.Advice
import com.itu.ituacmw3.Models.Slip
import org.json.JSONArray
import org.json.JSONObject

object JSONoperations {

    // Gets result as string in JSON format and returns an advice object.
    fun returnObjFromString(jsonRes:String):Advice{
        //Create an empty object
        val advice = Advice()

        val jsonObj = JSONObject(jsonRes)

        advice.total_results = (jsonObj.get("total_results") as String).toInt()
        advice.query = jsonObj.get("query") as String

        val jsonArr = jsonObj.getJSONArray("slips")

        for(i in 0 until jsonArr.length()){
            val slip = Slip()
            val jsonSlip = jsonArr.getJSONObject(i)
            slip.advice = jsonSlip.get("advice") as String
            slip.slip_id = (jsonSlip.get("slip_id") as String).toInt()
            advice.slips.add(slip)
        }

        return advice
    }
}