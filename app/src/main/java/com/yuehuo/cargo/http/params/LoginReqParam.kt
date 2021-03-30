package com.yuehuo.cargo.http.params

data class LoginReqParam(
    val phone: String,
    val password: String,
    val clientType: String,
    val deviceType: String,
    val loginType: Int
)