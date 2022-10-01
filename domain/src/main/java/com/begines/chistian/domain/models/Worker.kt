package com.begines.chistian.domain.models

data class Worker(
    var firstName: String,
    var lastName: String,
    var favorite: Favorite,
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
