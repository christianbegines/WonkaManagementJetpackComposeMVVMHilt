package com.begines.christian.data.mappers

import com.begines.chistian.domain.models.FilterWorker
import com.begines.christian.data.models.FilterWorkerApiModel
import javax.inject.Inject

class FilterMapper @Inject constructor() {

    fun mapWorkerListToData(list: List<FilterWorker>): List<FilterWorkerApiModel> {
        return list.map {
            mapFilterToApiModel(it)
        }
    }

    fun mapFilterToApiModel(apiModel: FilterWorker): FilterWorkerApiModel {
        return FilterWorkerApiModel(apiModel.name, apiModel.profession, apiModel.gender)
    }
}
