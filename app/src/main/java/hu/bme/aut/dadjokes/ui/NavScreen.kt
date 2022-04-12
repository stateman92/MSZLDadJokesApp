package hu.bme.aut.dadjokes.ui

sealed class NavScreen(val route: String) {
    object Home : NavScreen("Home")
    object Details : NavScreen("Details") {
        const val argument0 = "jokeId"
        const val routeWithArgument = "Details/{$argument0}"
    }
}