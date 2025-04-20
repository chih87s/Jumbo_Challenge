package com.db.data.repository

import com.db.common.Resource
import com.db.domain.entities.DetailsPageModel
import kotlinx.coroutines.flow.Flow

interface DetailsDataRepository {
    suspend fun getPropertyDetails(id: String): Flow<Resource<DetailsPageModel>>
}