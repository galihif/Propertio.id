package com.cinurawa.propertioid.di

import com.cinurawa.propertioid.data.MainRepository
import com.cinurawa.propertioid.data.MockRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RepositoryModule::class]
)
abstract class RepositoryTestModule {
    @Singleton
    @Binds
    abstract fun bindsMockRepository(
        mockRepositoryImpl: MockRepositoryImpl
    ): MainRepository
}