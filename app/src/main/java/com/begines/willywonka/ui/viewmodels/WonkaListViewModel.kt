package com.begines.willywonka.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.begines.chistian.domain.models.FilterWorker
import com.begines.chistian.domain.usecases.WorkerUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WonkaListViewModel @Inject constructor(
    workerUserCaseImpl: WorkerUserCase
) : ViewModel() {
    val workers = workerUserCaseImpl(FilterWorker())
}
