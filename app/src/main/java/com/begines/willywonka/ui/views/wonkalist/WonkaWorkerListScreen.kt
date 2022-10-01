package com.begines.willywonka.ui.views.wonkalist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.begines.chistian.domain.models.ui.WorkerUiModel
import kotlinx.coroutines.flow.Flow

@Composable
fun WonkaWorkerListScreen(
    workers: Flow<PagingData<WorkerUiModel>>,
    selectedWorker: (Int) -> Unit
) {
    val lazyMovieItems: LazyPagingItems<WorkerUiModel> = workers.collectAsLazyPagingItems()

    LazyColumn {
        items(lazyMovieItems, { worker ->
            worker.id
        }) { worker ->
            WorkerItem(worker = worker!!) { selectedWorker(worker.id) }
        }
    }
}

@Composable
fun WorkerItem(worker: WorkerUiModel, selectedWorker: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .fillMaxWidth().clickable(onClick = { selectedWorker(worker.id) }),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(text = worker.firstName)
    }
}
