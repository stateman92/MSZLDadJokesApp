package hu.bme.aut.dadjokes.ui.main.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hu.bme.aut.dadjokes.R
import hu.bme.aut.dadjokes.model.Joke
import hu.bme.aut.dadjokes.ui.base.composables.JokeText
import java.text.DateFormat.getDateTimeInstance

@Composable
fun JokeRow(
    modifier: Modifier = Modifier,
    joke: Joke,
    selectJoke: (String) -> Unit = { },
) {
    Surface(
        modifier = modifier
            .padding(all = 4.dp)
            .clickable(onClick = { selectJoke(joke.id) }),
        elevation = 16.dp,
        shape = RoundedCornerShape(size = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(
                    paddingValues = PaddingValues(
                        start = 8.dp,
                        end = 8.dp,
                        top = 4.dp,
                        bottom = 4.dp
                    )
                )
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JokeText(text = joke.headline)

            JokeText(text = getDateTimeInstance().format(joke.computedDate))

            if (joke.NSFW) {
                JokeText(text = stringResource(R.string.warning_nsfw))
            }
        }
    }
}