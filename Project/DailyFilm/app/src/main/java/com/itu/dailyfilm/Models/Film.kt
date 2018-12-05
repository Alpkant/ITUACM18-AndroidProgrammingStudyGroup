package com.itu.dailyfilm.Models

class Film(var title:String,
           var year:Int,
           var plot:String,
           var runtime: String,
           var imdbID:String,
           var ratings:MutableList<Ratings>)
{
    constructor():this("",0,"","","", mutableListOf())
}