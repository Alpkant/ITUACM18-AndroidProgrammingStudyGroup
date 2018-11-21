package com.itu.ituacmw3.Models

import com.google.gson.annotations.SerializedName

data class GsonSlip(
        @SerializedName("slip_id") val slip_id:Int,
        @SerializedName("advice") val advice:String )