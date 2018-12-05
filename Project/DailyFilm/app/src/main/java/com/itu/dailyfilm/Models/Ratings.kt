package com.itu.dailyfilm.Models

class Ratings(var source:String,
              var value:String)
{
    constructor():this("","")

    // Override this method to use simple list view
    override fun toString(): String {
        return "$source : $value"
    }
}