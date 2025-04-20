package com.db.data.di.module

import com.db.data.usecase.FetchDetailsDataUseCaseImpl
import com.db.domain.usecase.FetchDetailsDataUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule{
    @Binds
    abstract fun bindFetchDetailsDataUseCase(fetchDetailsDataUseCaseImpl: FetchDetailsDataUseCaseImpl): FetchDetailsDataUseCase
}