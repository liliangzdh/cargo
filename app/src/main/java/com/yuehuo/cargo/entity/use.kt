package com.yuehuo.cargo.entity

data class UserInfo(
    val balance: Double,
    val baseId: String,
    val baseUserId: String,
    val caSign: String,
    val cardId: String,
    val cashOutSign: String,
    val claimNum: Int,
    val cost: Double,
    val createTime: String,
    val endCardValidity: String,
    val headUrl: String,
    val id: Int,
    val idImgFront: String,
    val idImgHolding: String,
    val idImgReverse: String,
    val isFreeze: Int,
    val loginNum: Int,
    val loginTime: String,
    val mobile: String,
    val name: String,
    val num: Double,
    val organizeId: String,
    val reCode: String,
    val referrerAreaCode: String,
    val rid: Any,
    val sourceId: Int,
    val spCreateTime: Any,
    val startCardValidity: String,
    val state: Int,
    val userType: Int
)