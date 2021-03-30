package com.yuehuo.cargo.http

import com.baseHelp.mvvmbase.entity.BaseResponse
import com.yuehuo.cargo.http.params.LoginReqParam
import com.yuehuo.cargo.http.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("user/login")
    suspend fun passWord(@Body body: LoginReqParam): BaseResponse<LoginResponse>
}