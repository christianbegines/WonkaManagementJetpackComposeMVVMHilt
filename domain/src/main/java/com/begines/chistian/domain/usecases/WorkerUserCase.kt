package com.begines.chistian.domain.usecases

import androidx.paging.PagingData
import androidx.paging.map
import com.begines.chistian.domain.mappers.WorkerMapper
import com.begines.chistian.domain.models.FilterWorker
import com.begines.chistian.domain.models.ui.WorkerUiModel
import com.begines.chistian.domain.repositories.WorkerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WorkerUserCase @Inject constructor(
    private val workerRepository: WorkerRepository,
    private val mapper: WorkerMapper
) {
    operator fun invoke(filter: FilterWorker): Flow<PagingData<WorkerUiModel>> =
        workerRepository.getWorkers(filter).map {
            it.map { worker ->
                mapper.mapWorkerToUi(worker)
            }
        }
}
