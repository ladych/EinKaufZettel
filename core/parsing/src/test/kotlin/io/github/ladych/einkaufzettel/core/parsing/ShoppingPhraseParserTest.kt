package io.github.ladych.einkaufzettel.core.parsing

import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ShoppingPhraseParserTest {
    private val parser = ShoppingPhraseParser()

    @Test
    fun `a single product without quantity becomes one item`() {
        parser.parse("Milch") shouldBe listOf(ParsedItem(name = "Milch"))
    }

    @Test
    fun `surrounding whitespace is not part of the name`() {
        parser.parse("  Milch  ") shouldBe listOf(ParsedItem(name = "Milch"))
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\t"])
    fun `blank text yields no items`(text: String) {
        parser.parse(text).shouldBeEmpty()
    }
}
