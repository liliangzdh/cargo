package com.yuehuo.cargo.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.baseHelp.mvvmbase.base.BaseViewModel
import com.baseHelp.mvvmbase.http.base.RetrofitClient
import com.baseHelp.mvvmbase.utils.Preference
import com.google.gson.Gson
import com.hdl.elog.ELog
import com.yuehuo.cargo.http.UserApi
import com.yuehuo.cargo.http.params.LoginReqParam
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginViewModel : BaseViewModel() {

    private var xToken by Preference(Preference.Token, "")

    val userName = ObservableField<String>("19111111103")
    val passWord = ObservableField<String>("e10adc3949ba59abbe56e057f20f883e")


    // 密码状态
    val pswState = ObservableField<Boolean>(false)

    val pswStateEvent = MutableLiveData<Boolean>()


    fun login() {
        val userApi = RetrofitClient.create(UserApi::class.java)
        viewModelScope.launch(Dispatchers.Main) {
            val username = userName.get() ?: ""
            val password = passWord.get() ?: ""

            if (username.isEmpty() || password.isEmpty()) {
                showToast("用户名或密码不能为空")
                return@launch
            }

            showLoading("正在登陆...")

            val res = safeApi {
                userApi.passWord(LoginReqParam(username, password,"PC","",1))
            }
            if (res.code != 0) {
                showToast(res.msg)
                dismissLoading()
                return@launch
            }

            res.data?.apply {
                xToken = token

                ELog.e("test",token);
                ELog.e("test",Gson().toJson(userInfo));
                showToast("登录成功")
                dismissLoading()
                finish()
            }
        }
    }

    fun clearUsername() {
        userName.set("")
    }


    fun changePsw() {
        val state = pswState.get() ?: false
        pswState.set(!state)
        pswStateEvent.value = !state
    }


}