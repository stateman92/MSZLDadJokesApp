package hu.bme.aut.dadjokes.ui

sealed class NavScreen(val route: String) {
    object Home : NavScreen(route = "Home")
    object Details : NavScreen(route = "Details") {
        const val argument0 = "jokeId"
        const val routeWithArgument = "Details/{$argument0}"
    }
}