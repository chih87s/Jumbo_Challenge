package com.db.domain.usecase

import com.db.common.Resource
import com.db.domain.entities.AvailabilityInfo
import com.db.domain.entities.BasicInfo
import com.db.domain.entities.BookingInfo
import com.db.domain.entities.DetailsPageModel
import com.db.domain.entities.HostInfo
import com.db.domain.entities.LocationInfo
import com.db.domain.entities.PriceInfo
import com.db.domain.entities.Review
import kotlinx.coroutines.flow.Flow

interface FetchDetailsDataUseCase {
    suspend operator fun invoke(id: String): Flow<Resource<DetailsPageModel>>
}

