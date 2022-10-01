package com.begines.chistian.domain.mappers

import com.begines.chistian.domain.models.Favorite
import com.begines.chistian.domain.models.ui.FavoriteUiModel
import javax.inject.Inject

class FavoriteMapper @Inject constructor() {
    fun mapFavoriteModelTo(model: Favorite): FavoriteUiModel {
        return FavoriteUiModel(
            model.color,
            model.food,
            model.randomString,
            model.song
        )
    }
}