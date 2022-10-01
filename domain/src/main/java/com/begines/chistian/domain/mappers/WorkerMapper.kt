package com.begines.chistian.domain.mappers

import com.begines.chistian.domain.models.Worker
import com.begines.chistian.domain.models.ui.WorkerUiModel
import javax.inject.Inject

class WorkerMapper @Inject constructor(
    private val favoriteMapper: FavoriteMapper
) {

    fun mapWorkerListToUi(list: List<Worker>): List<WorkerUiModel> {
        return list.map {
            mapWorkerToUi(it)
        }
    }

    fun mapWorkerToUi(model: Worker): WorkerUiModel {
        return WorkerUiModel(
            model.firstName,
            model.lastName,
            favoriteMapper.mapFavoriteModelTo(model.favorite),
            model.gender,
            model.image,
            model.profession,
            model.email,
            model.age,
            model.country,
            model.height,
            model.id,
            model.quote,
            model.description
        )
    }
}