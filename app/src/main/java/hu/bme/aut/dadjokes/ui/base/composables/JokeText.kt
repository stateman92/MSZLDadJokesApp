package hu.bme.aut.dadjokes.ui.base.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun JokeText(
    text: String,
    padding: PaddingValues = PaddingValues(all = 4.dp),
    elevation: Dp = 0.dp,
    backgroundColor: Color = Color.White
) {
    Box(modifier = Modifier) {
        Card(
            modifier = Modifier,
            shape = RoundedCornerShape(12.dp),
            backgroundColor = backgroundColor,
            elevation = elevation
        ) {
            Text(
                modifier = Modifier
                    .padding(paddingValues = padding),
                text = text,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
            )
        }
    }
}