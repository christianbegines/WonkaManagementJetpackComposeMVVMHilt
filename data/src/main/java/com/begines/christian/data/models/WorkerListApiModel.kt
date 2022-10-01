package com.begines.christian.data.models

data class WorkerListApiModel(
    val results: List<WorkerApiModel>,
    val total: Int,
    val current: Int
)
