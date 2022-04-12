package hu.bme.aut.dadjokes.extensions

import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

fun LazyListScope.items(
    count: Int,
    key: ((index: Int) -> Any)? = null,
    itemContent: @Composable LazyItemScope.(index: Int) -> Unit,
    lastItemIsShown: () -> Unit
) {
    items(count = count, key = key) {
        if (it == count - 1) {
            LaunchedEffect(Unit) {
                lastItemIsShown()
            }
        }
        itemContent(it)
    }
}

fun <T> LazyListScope.items(
    items: List<T>,
    key: ((index: Int) -> Any)? = null,
    itemContent: @Composable LazyItemScope.(item: T) -> Unit,
    lastItemIsShown: () -> Unit
) {
    items(count = items.count(), key = key, itemContent = {
        itemContent(items[it])
    }) {
        lastItemIsShown()
    }
}