package com.example.androidassistant.module

import com.example.androidassistant.uitils.Constant
import com.google.gson.annotations.SerializedName

class InforamationContry {

    @SerializedName(Constant.Contry_Tital)
  //  @SerializedName("title")
    var cuntryTital: String? = null
    @SerializedName(Constant.Contry_Rows)
    var contryInfoRow = ArrayList<InfornationRow>()

    constructor(cuntryTital: String?, contryInfoRow: ArrayList<InfornationRow>) {
        this.cuntryTital = cuntryTital
        this.contryInfoRow = contryInfoRow
    }

    constructor()

   fun getInfornationRow(): ArrayList<InfornationRow> {
        return contryInfoRow
    }

    fun setInfornationRow(infornationRow: ArrayList<InfornationRow>) {
        this.contryInfoRow = infornationRow
    }

    fun getuntryTital(): String? {
        return cuntryTital
    }

    fun setcuntryTital(status: String) {
        this.cuntryTital = status
    }

    override fun toString(): String {
        return "InforamationContry(cuntryTital=$cuntryTital, contryInfoRow=$contryInfoRow)"
    }
}