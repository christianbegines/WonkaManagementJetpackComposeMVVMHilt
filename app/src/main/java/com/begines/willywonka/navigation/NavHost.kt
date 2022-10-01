package com.begines.willywonka.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.begines.willywonka.ui.viewmodels.WonkaListViewModel
import com.begines.willywonka.ui.views.wonkadetail.WonkaWorkerDetailScreen
import com.begines.willywonka.ui.views.wonkalist.WonkaWorkerListScreen

@Composable
fun WonkaManagementNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "wonkaList"
) {
    val actions = remember(navController) { AppActions(navController) }

    val listViewModel: WonkaListViewModel = viewModel()

    NavHost(navController, startDestination, modifier) {
        composable("wonkaList") {
            WonkaWorkerListScreen(
                listViewModel.workers,
                selectedWorker = actions.selectedWorker
            )
        }
        composable(
            "wonkaDetail/{id}",
            listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStack ->
            backStack.arguments?.getInt(ID)
                ?.let { id -> WonkaWorkerDetailScreen(id = id) }
        }
    }
}

private const val ID = "id"
