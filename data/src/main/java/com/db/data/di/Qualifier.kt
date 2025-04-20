package com.db.data.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RemoteDataSource



@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LocalDataSource