package com.example.androidassistant.retrofit;

import com.example.androidassistant.module.InforamationContry;
import com.example.androidassistant.uitils.Urls;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

 class RetrofitService {


   val retrofit = Retrofit.Builder()
       .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
   .addConverterFactory(GsonConverterFactory.create())
       .baseUrl(Urls.BASE_URL)
   .build()


    public fun <S> cteateService(serviceClass: Class<S>): S {
   return retrofit.create(serviceClass)
  }
}
