package hu.bme.aut.dadjokes.ui.base.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.bme.aut.dadjokes.R

@Composable
fun AppBar(
    title: String = stringResource(id = R.string.app_name),
    content: @Composable RowScope.() -> Unit = { }
) {
    TopAppBar(
        elevation = 6.dp,
        modifier = Modifier.height(58.dp)
    ) {
        Row {
            content()
            Text(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .align(alignment = Alignment.CenterVertically),
                text = title,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}