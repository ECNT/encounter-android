package com.liuxi.encounter.model.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by liuxi on 2018/3/26.
 */
object RetrofitManager {

    private fun getClient(): OkHttpClient {
        var interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return OkHttpClient.Builder().addNetworkInterceptor(interceptor).build()
    }

    fun <T> create(t: Class<T>): T {

        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RxJava
                .baseUrl(HttpConstants.ENCOUNTER)
                .client(getClient())
                .build()
                .create(t)
    }

}