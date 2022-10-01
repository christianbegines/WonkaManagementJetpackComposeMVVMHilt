package com.begines.christian.data

import com.begines.chistian.domain.repositories.WorkerRepository
import com.begines.christian.data.datasources.WorkerDataSource
import com.begines.christian.data.mappers.FavoriteMapper
import com.begines.christian.data.mappers.FilterMapper
import com.begines.christian.data.mappers.WorkerMapper
import com.begines.christian.data.repositories.WorkerRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Singleton
    @Provides
    fun provideFavoriteMapper(): FavoriteMapper = FavoriteMapper()

    @Singleton
    @Provides
    fun provideWorkerMapper(favoriteMapper: FavoriteMapper) = WorkerMapper(favoriteMapper)

    @Singleton
    @Provides
    fun provideFilterMapper(): FilterMapper = FilterMapper()

    @Singleton
    @Provides
    fun provideWorkerRepositorygit (
        dataSource: WorkerDataSource,
        workerMapper: WorkerMapper,
        filterMapper: FilterMapper
    ): WorkerRepository =
        WorkerRepositoryImpl(dataSource, workerMapper, filterMapper)
}
