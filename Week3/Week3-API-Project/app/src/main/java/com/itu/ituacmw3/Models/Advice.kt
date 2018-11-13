package com.itu.ituacmw3.Models

class Advice(var total_results:Int,var query:String,var slips:MutableList<Slip>) {
    constructor():this(0,"", mutableListOf())

    fun arrayOfSlips():Array<String?>{
        val slipArray = arrayOfNulls<String>(total_results)
        for ((i,item) in slips.withIndex()){
            slipArray[i] = item.advice
        }
        return slipArray
    }
}