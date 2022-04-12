package hu.bme.aut.dadjokes.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.insets.ProvideWindowInsets
import hu.bme.aut.dadjokes.ui.details.composables.DetailsScreen
import hu.bme.aut.dadjokes.ui.main.composables.MainScreen

@Composable
fun Screen() {
    val navController = rememberNavController()

    ProvideWindowInsets {
        NavHost(navController = navController, startDestination = NavScreen.Home.route) {
            composable(route = NavScreen.Home.route) {
                MainScreen(viewModel = hiltViewModel()) {
                    navController.navigate(route = "${NavScreen.Details.route}/$it")
                }
            }
            composable(
                route = NavScreen.Details.routeWithArgument,
                arguments = listOf(
                    navArgument(NavScreen.Details.argument0) { type = NavType.StringType }
                )
            ) {
                DetailsScreen(viewModel = hiltViewModel()) {
                    navController.navigateUp()
                }
            }
        }
    }
}