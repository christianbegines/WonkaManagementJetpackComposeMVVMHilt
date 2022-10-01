package com.begines.christian.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.begines.chistian.domain.models.FilterWorker
import com.begines.chistian.domain.models.Worker
import com.begines.chistian.domain.repositories.WorkerRepository
import com.begines.christian.data.datasources.WorkerDataSource
import com.begines.christian.data.mappers.FilterMapper
import com.begines.christian.data.mappers.WorkerMapper
import com.begines.christian.data.models.WorkerApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WorkerRepositoryImpl @Inject constructor(
    private val workerDataSource: WorkerDataSource,
    private val mapper: WorkerMapper,
    private val filterMapper: FilterMapper
) : WorkerRepository {

    override fun getWorkers(filter: FilterWorker): Flow<PagingData<Worker>> {
        return Pager(
            config = PagingConfig(
                pageSize = 25,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                workerDataSource.getWorkers(filterMapper.mapFilterToApiModel(filter))
            }
        ).flow.map { paging: PagingData<WorkerApiModel> ->
            paging.map {
                mapper.mapWorkerApiModelToData(it)
            }
        }
    }
}
