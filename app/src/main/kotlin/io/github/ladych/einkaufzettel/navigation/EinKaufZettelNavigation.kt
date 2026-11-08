package io.github.ladych.einkaufzettel.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import io.github.ladych.einkaufzettel.feature.shopping.ShoppingListRoute
import io.github.ladych.einkaufzettel.feature.shopping.ShoppingListScreen

/** Navigation 3: the back stack is plain Compose state owned by the app. */
@Composable
fun EinKaufZettelNavigation(modifier: Modifier = Modifier) {
    val backStack = remember { mutableStateListOf<Any>(ShoppingListRoute) }

    NavDisplay(
        backStack = backStack,
        modifier = modifier,
        onBack = { backStack.removeLastOrNull() },
        entryProvider =
            entryProvider {
                entry<ShoppingListRoute> { ShoppingListScreen() }
            },
    )
}
