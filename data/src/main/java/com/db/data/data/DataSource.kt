package com.db.data.data

import com.db.data.data.entities.ResponseAvailabilityInfo
import com.db.data.data.entities.ResponseBasicInfo
import com.db.data.data.entities.ResponseBookingInfo
import com.db.data.data.entities.ResponseDetailsPageModel
import com.db.data.data.entities.ResponseHostInfo
import com.db.data.data.entities.ResponseLocationInfo
import com.db.data.data.entities.ResponsePriceInfo
import com.db.data.data.entities.ResponseReview
import retrofit2.Response

interface DataSource {
    suspend fun getDetailsInfo(id:String): Response<ResponseDetailsPageModel>
}