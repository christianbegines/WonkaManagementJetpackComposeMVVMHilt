package com.begines.christian.networkdatasource.datasources

import com.begines.christian.data.datasources.WorkerDataSource
import com.begines.christian.data.models.FilterWorkerApiModel
import com.begines.christian.networkdatasource.remote.AppService
import javax.inject.Inject

private const val NETWORK_PAGE_SIZE = 25

class WorkerDataSourceImpl @Inject constructor(
    private val apiService: AppService
) : WorkerDataSource {

    override fun getWorkers(filter: FilterWorkerApiModel): WorkerPagingSourceImpl =
        WorkerPagingSourceImpl(apiService = apiService, filter = filter)

    companion object {
        fun create(apiService: AppService): WorkerDataSourceImpl =
            WorkerDataSourceImpl(apiService)
    }
}
