
package com.test.nyc.di

import com.test.nyc.data.repository.SchoolsRepositoryImpl
import com.test.nyc.domain.repository.SchoolsRepository
import com.test.nyc.domain.usecase.GetSatUseCase
import com.test.nyc.domain.usecase.GetSchoolsUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindModule {
    @Binds
    abstract fun bindSchoolsRepo(impl: SchoolsRepositoryImpl): SchoolsRepository
}

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetSchoolsUseCase(repo: SchoolsRepository): GetSchoolsUseCase = GetSchoolsUseCase(repo)

    @Provides
    @Singleton
    fun provideGetSatUseCase(repo: SchoolsRepository): GetSatUseCase = GetSatUseCase(repo)
}
