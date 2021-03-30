package com.baseHelp.mvvmbase.http.base

import com.baseHelp.mvvmbase.utils.Preference
import okhttp3.Interceptor
import okhttp3.Response

class RequestIntercept : Interceptor {

    var token by Preference(Preference.Token, "")

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val builder = request.newBuilder()
        if (token.isNotEmpty()) {
            builder.addHeader("token", token)
        }
        builder.addHeader("App-Version", "1.8.25")
        return chain.proceed(builder.build())
    }
}