package com.itu.ituacmw3

interface ConnectionInterface {
    fun onSuccess(result:String)
    fun onError(errorString:String)
}