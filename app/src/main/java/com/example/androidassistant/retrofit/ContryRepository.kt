package com.example.androidassistant.retrofit

import androidx.lifecycle.MutableLiveData
import com.example.androidassistant.module.InforamationContry
import com.example.androidassistant.module.InfornationRow
import com.example.androidassistant.uitils.AppLog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ContryRepository {


    private val contryApi: ContryApi

    init {
        contryApi = RetrofitService().cteateService(ContryApi::class.java)
    }
     fun getData(): MutableLiveData<InforamationContry> {
        val newsData = MutableLiveData<InforamationContry>()
        contryApi.getData().enqueue(object : Callback<InforamationContry> {
            override fun onResponse(
                call: Call<InforamationContry>,
                response: Response<InforamationContry>
            ) {
                if (response.isSuccessful()) {
                    newsData.setValue(response.body())
                    AppLog.e("Contry Repository class", "output  ------------->"+ response.body()?.toString())
                }
            }

            override fun onFailure(call: Call<InforamationContry>, t: Throwable) {
                newsData.setValue(null)
            }
        })
        return newsData
    }

    companion object {

        private var contryRepository: ContryRepository? = null

        val instance: ContryRepository
            get() {
                if (contryRepository == null) {
                    contryRepository = ContryRepository()
                }
                return contryRepository!!
            }
    }
}