package com.begines.christian.networkdatasource.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.begines.christian.data.models.FilterWorkerApiModel
import com.begines.christian.data.models.WorkerApiModel
import com.begines.christian.networkdatasource.remote.AppService

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

class WorkerPagingSourceImpl(
    private val apiService: AppService,
    private val filter: FilterWorkerApiModel
) : PagingSource<Int, WorkerApiModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, WorkerApiModel> {
        return try {
            val nextPageNumber = params.key ?: UNSPLASH_STARTING_PAGE_INDEX
            val response = apiService.getWorkerList(nextPageNumber).results.toList()
            LoadResult.Page(
                data = filter(filter, response),
                prevKey = null,
                nextKey = if (response.isNotEmpty()) nextPageNumber + UNSPLASH_STARTING_PAGE_INDEX else null
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, WorkerApiModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

    private fun filter(
        filter: FilterWorkerApiModel,
        list: List<WorkerApiModel>
    ): List<WorkerApiModel> {
        var oompaLoompas: List<WorkerApiModel> = list
        filter.gender?.let {
            oompaLoompas = oompaLoompas.filter {
                it.gender.lowercase().contains(filter.gender!!.lowercase())
            }
        }
        filter.name?.let {
            oompaLoompas = oompaLoompas.filter {
                it.firstName.lowercase().contains(filter.name!!.lowercase())
            }
        }
        filter.profession?.let {
            oompaLoompas = oompaLoompas.filter {
                it.profession.lowercase().contains(filter.profession!!.lowercase())
            }
        }
        return oompaLoompas
    }
}
