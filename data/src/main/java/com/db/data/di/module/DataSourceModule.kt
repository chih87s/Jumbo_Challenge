package com.db.data.di.module

import com.db.data.data.DataSource
import com.db.data.data.remote.RemoteDataSourceImpl
import com.db.data.di.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule{

    @Binds
    @RemoteDataSource
    abstract fun bindDataSource(remoteDataSource: RemoteDataSourceImpl): DataSource

}
