package com.itu.ituacmw3.Models

import com.google.gson.annotations.SerializedName

data class GsonAdvice(
        @SerializedName("total_results") val total_results:Int,
        @SerializedName("query") val query:String,
        @SerializedName("slips") val slips:List<GsonSlip>){

    fun getAdviceList(): Array<String?> {
        val slipArray = arrayOfNulls<String>(total_results)
        for ((i,item) in slips.withIndex()){
            slipArray[i] = item.advice
        }
        return slipArray
    }
}