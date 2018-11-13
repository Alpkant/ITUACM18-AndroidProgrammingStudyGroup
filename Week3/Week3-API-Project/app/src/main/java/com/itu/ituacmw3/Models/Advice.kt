package com.itu.ituacmw3.Models

class Advice(var total_results:Int,var query:String,var slips:MutableList<Slip>) {
    constructor():this(0,"", mutableListOf())
}