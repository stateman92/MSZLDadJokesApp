package hu.bme.aut.dadjokes.ui.main.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.constraintlayout.compose.ConstraintLayout
import hu.bme.aut.dadjokes.extensions.visible
import hu.bme.aut.dadjokes.ui.base.composables.AppBar
import hu.bme.aut.dadjokes.ui.main.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    selectJoke: (String) -> Unit
) {
    val jokes by viewModel.jokes
    val isLoading by viewModel.isLoading

    ConstraintLayout {
        val (_, progress) = createRefs()

        Scaffold(topBar = { AppBar() }) {
            JokeList(
                modifier = Modifier
                    .padding(paddingValues = it)
                    .alpha(alpha = if (isLoading) 0.5f else 1f),
                jokes = jokes,
                selectJoke = selectJoke
            ) {
                viewModel.requestMore()
            }
        }
        CircularProgressIndicator(
            modifier = Modifier
                .constrainAs(ref = progress) {
                    top.linkTo(anchor = parent.top)
                    bottom.linkTo(anchor = parent.bottom)
                    start.linkTo(anchor = parent.start)
                    end.linkTo(anchor = parent.end)
                }
                .visible(visibility = isLoading)
        )
    }
}