package io.github.ladych.einkaufzettel.feature.shopping

sealed interface ShoppingListUiState {
    data object Empty : ShoppingListUiState
}
