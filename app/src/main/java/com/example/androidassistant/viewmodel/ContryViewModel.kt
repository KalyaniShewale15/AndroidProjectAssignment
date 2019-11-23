package com.example.androidassistant.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidassistant.module.InforamationContry
import com.example.androidassistant.retrofit.ContryRepository
import com.example.androidassistant.uitils.AppLog


class ContryViewModel : ViewModel() {

    private var mutableLiveData: MutableLiveData<InforamationContry>? = null
    private var contryRepository: ContryRepository? = null

    fun init() {
        if (mutableLiveData != null) {
            return
        }
        contryRepository = ContryRepository.instance
        mutableLiveData = contryRepository!!.getData()
       // AppLog.e("----contry view model", " output in init methed-------------> ${mutableLiveData.toString()}")

    }

    fun getContryRepository(): LiveData<InforamationContry>? {
        AppLog.e("----contry view model", " output in getContryRepository-------------> ${mutableLiveData.toString()}")
        return mutableLiveData
    }

}