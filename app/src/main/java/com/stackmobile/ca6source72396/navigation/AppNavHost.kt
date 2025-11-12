package com.stackmobile.ca6source72396.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.stackmobile.ca6source72396.screens.DetailScreen
import com.stackmobile.ca6source72396.screens.ListScreen
import com.stackmobile.ca6source72396.utils.ResultKeys

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.List.route
    ) {

        composable(NavRoutes.List.route) {
            ListScreen(
                onNavigateToDetail = { id ->
                    // chame sem nome pra evitar erro de parâmetro nomeado
                    navController.navigate(NavRoutes.Detail.build(id))
                },
                // Passa o handle atual para observar o resultado
                currentSavedStateHandle = navController.currentBackStackEntry?.savedStateHandle
            )
        }


        composable(
            route = NavRoutes.Detail.route,
            arguments = listOf(
                navArgument(NavRoutes.Detail.ARG_ITEM_ID) { type = NavType.IntType }
            )
        ) { backStackEntry ->
            DetailScreen(
                backStackEntry = backStackEntry,
                onConfirm = { id ->

                    val prevHandle = navController.previousBackStackEntry?.savedStateHandle
                    prevHandle?.set(ResultKeys.ITEM_RESULT_KEY, "Confirmed: $id")
                    navController.popBackStack()
                }
            )
        }
    }
}

