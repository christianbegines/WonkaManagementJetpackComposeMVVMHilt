package com.begines.chistian.domain.models.ui

data class WorkerUiModel(
    var firstName: String,
    var lastName: String,
    var favorite: FavoriteUiModel,
    var gender: String,
    var image: String,
    var profession: String,
    var email: String,
    var age: Int,
    var country: String,
    var height: Int,
    var id: Int,
    var quote: String?,
    var description: String?
)
