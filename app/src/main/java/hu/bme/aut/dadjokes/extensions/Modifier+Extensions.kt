package hu.bme.aut.dadjokes.extensions

import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha

@Stable
fun Modifier.visible(visibility: Boolean) = then(other = alpha(alpha = if (visibility) 1f else 0f))