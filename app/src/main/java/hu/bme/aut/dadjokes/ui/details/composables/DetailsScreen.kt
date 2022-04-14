package hu.bme.aut.dadjokes.ui.details.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.bme.aut.dadjokes.ui.details.DetailsViewModel
import hu.bme.aut.dadjokes.ui.main.composables.JokeRow

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel,
    pressOnBack: () -> Unit
) {
    val joke by viewModel.joke

    Scaffold(topBar = { BackButtonBar(pressOnBack = pressOnBack) }) {
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(space = 16.dp)
        ) {
            JokeRow(joke = joke)
            JokeDetailsRow(joke = joke, pressOnBack = pressOnBack)
        }
    }
}