package com.itu.proje3

import com.itu.proje3.Models.Advice
import com.itu.proje3.Models.Slip
import org.json.JSONObject


object JsonOperations {
    fun returnObjFromStr(result:String) : Advice{
        var advice = Advice()
        var jsonObject = JSONObject(result)

        if (!jsonObject.has("total_results"))
            return advice

        if (jsonObject.has("total_results"))
            advice.total_results =  (jsonObject.get("total_results") as String).toInt()

        if (jsonObject.has("query"))
            advice.query =  jsonObject.get("query") as String

        if (jsonObject.has("slips")){
            var jsonArr = jsonObject.getJSONArray("slips")
            for (i in 0 until jsonArr.length()){
                var slip = Slip()
                var jsonSlip = jsonArr.getJSONObject(i)
                if (jsonSlip.has("advice"))
                    slip.advice = jsonSlip.get("advice") as String
                if (jsonSlip.has("slip_id"))
                    slip.slip_id = (jsonSlip.get("slip_id") as String).toInt()
                advice.slips.add(slip)
            }
        }
        return advice
    }
}