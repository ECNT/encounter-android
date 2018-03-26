package com.liuxi.encounter.model.http.api

import com.liuxi.encounter.model.http.HttpConstants
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.*

/**
 * Created by liuxi on 2018/3/26.
 */
interface LoginApi {

    @FormUrlEncoded
    @POST(HttpConstants.LOGIN)
    fun login(@Field("username") username: String,
              @Field("password") pwd: String)
            : Observable


}