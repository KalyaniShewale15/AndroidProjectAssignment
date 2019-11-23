package com.example.androidassistant.module

import com.example.androidassistant.uitils.Constant
import com.example.androidassistant.uitils.Urls
import com.google.gson.annotations.SerializedName

class InfornationRow {

    @SerializedName(Constant.Contry_Sub_Tital)
    var cuntrySubTital: String? = null
    @SerializedName("description")
    var cuntryDescription: String? = null
   @SerializedName("imageHref")
    var cuntryDesImg: String? = null



    constructor(cuntrySubTital: String?, cuntryDescription: String?, cuntryDesImg: String?) {
        this.cuntrySubTital = cuntrySubTital
        this.cuntryDescription = cuntryDescription
        this.cuntryDesImg = cuntryDesImg
    }

    constructor()

    override fun toString(): String {
        return "InfornationRow(cuntrySubTital=$cuntrySubTital, cuntryDescription=$cuntryDescription, cuntryDesImg=$cuntryDesImg)"
    }
}