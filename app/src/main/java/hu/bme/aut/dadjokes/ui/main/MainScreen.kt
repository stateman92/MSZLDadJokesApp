package hu.bme.aut.dadjokes.ui.main

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.insets.ProvideWindowInsets
import hu.bme.aut.dadjokes.R
import hu.bme.aut.dadjokes.ui.AppBar
import hu.bme.aut.dadjokes.ui.NavScreen
import hu.bme.aut.dadjokes.ui.details.DetailsScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    ProvideWindowInsets {
        NavHost(navController = navController, startDestination = NavScreen.Home.route) {
            composable(NavScreen.Home.route) {
                Scaffold(topBar = { AppBar() }) {
                    Button(onClick = {
                        navController.navigate("${NavScreen.Details.route}/111")
                    }) {
                        Text(text = "Navigate next")
                    }
                }
            }
            composable(
                route = NavScreen.Details.routeWithArgument,
                arguments = listOf(
                    navArgument(NavScreen.Details.argument0) { type = NavType.LongType }
                )
            ) { _ ->
                DetailsScreen {
                    navController.navigateUp()
                }
            }
        }
    }
}