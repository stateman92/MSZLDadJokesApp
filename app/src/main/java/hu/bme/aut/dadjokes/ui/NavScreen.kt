package hu.bme.aut.dadjokes.ui

sealed class NavScreen(val route: String) {
    object Home: NavScreen("Home")
    object Details: NavScreen("Details") {
        const val routeWithArgument = "Details/{jokeId}"
        const val argument0 = "jokeId"
    }
}