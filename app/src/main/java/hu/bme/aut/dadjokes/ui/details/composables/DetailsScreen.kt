package hu.bme.aut.dadjokes.ui.details.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import hu.bme.aut.dadjokes.ui.details.DetailsViewModel

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel,
    pressOnBack: () -> Unit
) {
    val joke by viewModel.joke

    BackButton(pressOnBack = pressOnBack)
    Text(text = joke.headline)
}