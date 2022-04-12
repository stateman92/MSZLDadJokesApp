package hu.bme.aut.dadjokes.ui.main.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding
import hu.bme.aut.dadjokes.extensions.items
import hu.bme.aut.dadjokes.model.Joke

@Composable
fun JokeList(
    modifier: Modifier,
    jokes: List<Joke>,
    selectJoke: (String) -> Unit,
    requestMore: () -> Unit
) {
    LazyColumn(
        modifier = modifier
            .statusBarsPadding()
    ) {
        items(
            items = jokes,
            itemContent = {
                JokeRow(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                    joke = it,
                    selectJoke = selectJoke
                )
            }) {
            requestMore()
        }
    }
}