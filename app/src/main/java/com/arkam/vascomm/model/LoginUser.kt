package com.arkam.vascomm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginUser{
    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null
}


