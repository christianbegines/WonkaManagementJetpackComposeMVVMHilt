package com.begines.christian.data.mappers

import com.begines.chistian.domain.models.Favorite
import com.begines.christian.data.models.FavoriteApiModel
import javax.inject.Inject

class FavoriteMapper @Inject constructor() {
    fun mapFavoriteApiModelToData(apiModel: FavoriteApiModel): Favorite {
        return Favorite(
            apiModel.color,
            apiModel.food,
            apiModel.randomString,
            apiModel.song
        )
    }
}
