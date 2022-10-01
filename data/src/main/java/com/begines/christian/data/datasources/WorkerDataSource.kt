package com.begines.christian.data.datasources

import androidx.paging.PagingSource
import com.begines.christian.data.models.FilterWorkerApiModel
import com.begines.christian.data.models.WorkerApiModel

interface WorkerDataSource {
    fun getWorkers(filter: FilterWorkerApiModel): PagingSource<Int, WorkerApiModel>
}
