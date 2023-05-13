package com.arkam.vascomm.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponse{
    @SerializedName("token")
    @Expose
    var token: String? = null
}



