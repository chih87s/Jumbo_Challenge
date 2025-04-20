package com.db.data.api


import com.db.data.data.entities.ResponseDetailsPageModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

    @GET("details/{id}")
    suspend fun getDetailsInfo(id:String):Response<ResponseDetailsPageModel>

}