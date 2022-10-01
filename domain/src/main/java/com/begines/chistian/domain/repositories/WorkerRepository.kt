package com.begines.chistian.domain.repositories

import androidx.paging.PagingData
import com.begines.chistian.domain.models.FilterWorker
import com.begines.chistian.domain.models.Worker
import kotlinx.coroutines.flow.Flow

interface WorkerRepository {
    fun getWorkers(filter: FilterWorker): Flow<PagingData<Worker>>
}
