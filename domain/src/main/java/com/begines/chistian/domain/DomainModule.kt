package com.begines.chistian.domain

import com.begines.chistian.domain.mappers.WorkerMapper
import com.begines.chistian.domain.repositories.WorkerRepository
import com.begines.chistian.domain.usecases.WorkerUserCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideWorkerUseCase(
        workerRepository: WorkerRepository,
        mapper: WorkerMapper
    ): WorkerUserCase =
        WorkerUserCase(workerRepository, mapper)
}
