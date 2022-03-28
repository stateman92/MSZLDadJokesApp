package hu.bme.aut.dadjokes.ui.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import hu.bme.aut.dadjokes.R

@Composable
fun DetailsScreen(pressOnBack: () -> Unit) {
    Icon(
        imageVector = Icons.Filled.ArrowBack,
        tint = Color(R.color.purple_200),
        contentDescription = null,
        modifier = Modifier
            .padding(12.dp)
            .clickable(onClick = pressOnBack)
    )
}