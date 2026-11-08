package io.github.ladych.einkaufzettel.feature.shopping

import org.junit.Assert.assertEquals
import org.junit.Test

class ShoppingListViewModelTest {
    @Test
    fun `a new shopping list starts empty`() {
        val viewModel = ShoppingListViewModel()

        assertEquals(ShoppingListUiState.Empty, viewModel.uiState.value)
    }
}
