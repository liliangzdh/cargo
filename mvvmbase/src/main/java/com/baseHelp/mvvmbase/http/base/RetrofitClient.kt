package com.baseHelp.mvvmbase.http.base

import com.baseHelp.mvvmbase.BuildConfig
import com.baseHelp.mvvmbase.config.Url
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {


    private const val timeOut = 3


    // 生产 okHttpClient
    private val client: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder()
            val loggingInterceptor = HttpLoggingInterceptor()


            if (BuildConfig.DEBUG) {
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            } else {
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
            }


            builder.addInterceptor(loggingInterceptor)
                .addInterceptor(RequestIntercept())
                .connectTimeout(timeOut.toLong(), TimeUnit.SECONDS)


            return builder.build()
        }

    private val retrofit: Retrofit
        get() {
            return Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Url.BaseUrl)
                .build()
        }

    // 为了 协程 Deferred 能用 添加
    // com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
//    private val retrofit: Retrofit
//        get() {
//            return Retrofit.Builder()
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(CoroutineCallAdapterFactory())
//                .baseUrl(Url.BaseUrl)
//                .build()
//        }


    // 创建
    fun <S> create(apiClass: Class<S>): S {
        return retrofit.create(apiClass)

    }

}