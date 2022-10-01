package com.begines.christian.networkdatasource

import com.begines.christian.data.datasources.WorkerDataSource
import com.begines.christian.networkdatasource.datasources.WorkerDataSourceImpl
import com.begines.christian.networkdatasource.remote.AppService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideAppService(): AppService {
        return AppService.create()
    }

    @Singleton
    @Provides
    fun provideWorkerDataSource(apiService: AppService): WorkerDataSource {
        return WorkerDataSourceImpl.create(apiService)
    }
}
