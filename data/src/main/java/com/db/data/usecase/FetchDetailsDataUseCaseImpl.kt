package com.db.data.usecase

import com.db.common.Resource
import com.db.data.repository.DetailsDataRepository
import com.db.domain.entities.DetailsPageModel
import com.db.domain.usecase.FetchDetailsDataUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchDetailsDataUseCaseImpl @Inject constructor(
    private val repository: DetailsDataRepository,
) : FetchDetailsDataUseCase {

    override suspend operator fun invoke(id: String): Flow<Resource<DetailsPageModel>> {
        return repository.getPropertyDetails(id)
    }


}