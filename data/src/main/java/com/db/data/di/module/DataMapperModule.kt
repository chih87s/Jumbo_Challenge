package com.db.data.di.module

import com.db.common.extensions.DataToDomainModelMapper
import com.db.data.data.entities.ResponseDetailsPageModel
import com.db.data.mapper.DetailsPageDomainModelMapper
import com.db.domain.entities.DetailsPageModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataMapperModule {

    @Binds
    abstract fun bindDetailsPageDomainModelMapper(
        detailsPageDomainModelMapper: DetailsPageDomainModelMapper
    ): DataToDomainModelMapper<ResponseDetailsPageModel, DetailsPageModel>
}
