package hu.bme.aut.dadjokes.ui.main

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.constraintlayout.compose.ConstraintLayout
import hu.bme.aut.dadjokes.extensions.visible

@Composable
fun Jokes(
    viewModel: MainViewModel,
    selectJoke: (Long) -> Unit
) {
    val jokes by viewModel.jokeList.collectAsState(initial = listOf())
    val isLoading by viewModel.isLoading
    ConstraintLayout {
        val (body, progress) = createRefs()

        Scaffold(topBar = { hu.bme.aut.dadjokes.ui.AppBar() }) {
            Button(onClick = {
                selectJoke(111)
            }) {
                Text(text = "Navigate ${jokes.count()}")
            }
        }
        CircularProgressIndicator(
            modifier = androidx.compose.ui.Modifier
                .constrainAs(progress) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .visible(isLoading)
        )
    }
}