package com.db.data.data.remote

import com.db.common.Resource
import com.db.data.api.ApiServices
import com.db.data.data.DataSource
import com.db.data.data.entities.ResponseDetailsPageModel
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiServices: ApiServices
):DataSource {
    override suspend fun getDetailsInfo(id: String): Response<ResponseDetailsPageModel> {
        return  apiServices.getDetailsInfo(id)
    }

}