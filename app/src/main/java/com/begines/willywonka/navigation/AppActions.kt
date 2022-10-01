package com.begines.willywonka.navigation

import androidx.navigation.NavHostController

class AppActions(
    navController: NavHostController
) {
    val selectedWorker: (Int) -> Unit = { id: Int ->
        navController.navigate("wonkaDetail/$id")
    }

    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}
