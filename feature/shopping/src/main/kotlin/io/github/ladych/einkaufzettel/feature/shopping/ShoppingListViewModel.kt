package io.github.ladych.einkaufzettel.feature.shopping

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ShoppingListViewModel : ViewModel() {
    val uiState: StateFlow<ShoppingListUiState> =
        MutableStateFlow<ShoppingListUiState>(ShoppingListUiState.Empty).asStateFlow()
}
