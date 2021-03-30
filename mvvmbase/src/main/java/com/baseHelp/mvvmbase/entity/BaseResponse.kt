package com.baseHelp.mvvmbase.entity


data class BaseResponse<out T>
    (
    val code: Int,
    val msg: String?,
    val data: T?,
    val count: Int
)