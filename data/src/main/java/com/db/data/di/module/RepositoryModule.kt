package com.db.data.di.module

import com.db.data.repository.DetailsDataRepository
import com.db.data.repository.DetailsDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindDetailsDataRepository(
        detailsDataRepositoryImpl: DetailsDataRepositoryImpl
    ): DetailsDataRepository

}
