package com.db.data.repository


import com.db.common.Resource
import com.db.common.di.IoDispatcher
import com.db.common.extensions.DataToDomainModelMapper
import com.db.data.data.DataSource
import com.db.data.data.entities.ResponseDetailsPageModel
import com.db.data.di.RemoteDataSource
import com.db.data.extensions.handleAPICall
import com.db.domain.entities.DetailsPageModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class DetailsDataRepositoryImpl @Inject constructor(
    @RemoteDataSource private val remoteDataSource: DataSource,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val dataToDomainModelMapper: DataToDomainModelMapper<ResponseDetailsPageModel, DetailsPageModel>
) : DetailsDataRepository {

    override suspend fun getPropertyDetails(id: String): Flow<Resource<DetailsPageModel>> {
        return flow {
            val resource = handleAPICall { remoteDataSource.getDetailsInfo(id) }

            when(resource){
                is Resource.Success->{
                    //TODO assuming mapping Response model to domain model is success
                    val details:DetailsPageModel = resource.data.let {
                        dataToDomainModelMapper.mapToDomainModel(it)
                    }
                    emit(Resource.createSuccess(details))
                }
                is Resource.Failure ->{
                    emit(resource)
                }

            }
        }.flowOn(dispatcher)
    }


}