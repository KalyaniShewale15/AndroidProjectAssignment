package com.example.androidassistant.retrofit

import com.example.androidassistant.module.InforamationContry
import com.example.androidassistant.uitils.Urls
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
// Api interface for call retrofit call
// also have call back function getData()
interface ContryApi {
   // @GET(Urls.URL)
   @GET("s/2iodh4vg0eortkl/facts.json/")
    fun getData(): Call<InforamationContry>
}