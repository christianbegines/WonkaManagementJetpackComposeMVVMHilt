package com.begines.christian.data.mappers

import com.begines.chistian.domain.models.Worker
import com.begines.christian.data.models.WorkerApiModel
import javax.inject.Inject

class WorkerMapper @Inject constructor(
    private val favoriteMapper: FavoriteMapper
) {

    fun mapWorkerListToData(list: List<WorkerApiModel>): List<Worker> {
        return list.map {
            mapWorkerApiModelToData(it)
        }
    }

    fun mapWorkerApiModelToData(apiModel: WorkerApiModel): Worker {
        return Worker(
            apiModel.firstName,
            apiModel.lastName,
            favoriteMapper.mapFavoriteApiModelToData(apiModel.favoriteApiModel),
            apiModel.gender,
            apiModel.image,
            apiModel.profession,
            apiModel.email,
            apiModel.age,
            apiModel.country,
            apiModel.height,
            apiModel.id,
            apiModel.quote,
            apiModel.description
        )
    }
}
