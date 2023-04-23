package com.cinurawa.propertioid.di

import com.cinurawa.propertioid.data.MainRepository
import com.cinurawa.propertioid.data.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [RemoteModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindsMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository
}