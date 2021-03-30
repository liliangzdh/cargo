package com.yuehuo.cargo.http.response

import com.yuehuo.cargo.entity.UserInfo

data class LoginResponse(val token: String, val userInfo: UserInfo)