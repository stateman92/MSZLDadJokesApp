package hu.bme.aut.dadjokes.ui.details.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hu.bme.aut.dadjokes.R
import hu.bme.aut.dadjokes.model.Joke
import hu.bme.aut.dadjokes.ui.base.composables.JokeText

@Composable
fun JokeDetailsRow(
    modifier: Modifier = Modifier,
    joke: Joke,
    pressOnBack: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            elevation = 16.dp,
            shape = RoundedCornerShape(size = 24.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .padding(paddingValues = PaddingValues(all = 8.dp))
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(space = 8.dp)
            ) {
                JokeText(
                    modifier = Modifier.align(alignment = Alignment.Start),
                    text = joke.author,
                    padding = PaddingValues(all = 8.dp),
                    backgroundColor = MaterialTheme.colors.primarySurface
                )

                JokeText(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                    text = joke.punchline,
                    style = MaterialTheme.typography.h5
                )

                JokeText(
                    modifier = Modifier.align(alignment = Alignment.End),
                    text = joke.type,
                    padding = PaddingValues(all = 8.dp),
                    backgroundColor = MaterialTheme.colors.primarySurface
                )
            }
        }

        Spacer(modifier = Modifier.size(size = 64.dp))

        JokeText(
            modifier = Modifier.clickable(onClick = pressOnBack),
            text = stringResource(id = R.string.show_more_jokes),
            padding = PaddingValues(all = 16.dp),
            style = MaterialTheme.typography.h6,
            backgroundColor = MaterialTheme.colors.primarySurface
        )
    }
}