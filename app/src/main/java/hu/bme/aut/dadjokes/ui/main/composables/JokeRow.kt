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
import androidx.compose.ui.unit.dp
import hu.bme.aut.dadjokes.model.Joke
import hu.bme.aut.dadjokes.ui.base.composables.JokeText
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun JokeRow(
    modifier: Modifier = Modifier,
    joke: Joke,
    selectJoke: (String) -> Unit = { },
) {
    Surface(
        modifier = modifier
            .padding(4.dp)
            .clickable(
                onClick = { selectJoke(joke.id) }
            ),
        elevation = 16.dp,
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(PaddingValues(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp))
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JokeText(
                text = joke.headline,
                backgroundColor = Color.LightGray
            )

            JokeText(
                text = SimpleDateFormat("yyyy.MM.dd. HH:mm").format(Date(joke.date.toLong())),
                backgroundColor = Color.LightGray
            )

            if (joke.NSFW) {
                JokeText(text = "Warning! NSFW!", backgroundColor = Color.LightGray)
            }
        }
    }
}