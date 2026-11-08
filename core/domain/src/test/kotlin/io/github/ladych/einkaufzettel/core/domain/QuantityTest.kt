package io.github.ladych.einkaufzettel.core.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class QuantityTest {
    @Test
    fun `whole and decimal notation of the same amount are equal`() {
        Quantity.of("2.0") shouldBe Quantity.of(2)
    }

    @Test
    fun `decimal amounts keep their exact value`() {
        Quantity.of("1.5").toString() shouldBe "1.5"
    }

    @Test
    fun `large whole amounts are printed without exponent`() {
        Quantity.of(100).toString() shouldBe "100"
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "0.0", "-1", "-0.5"])
    fun `zero and negative amounts are rejected`(value: String) {
        shouldThrow<IllegalArgumentException> { Quantity.of(value) }
    }

    @Test
    fun `every positive whole number is a valid quantity`() =
        runTest {
            checkAll(Arb.int(1..Int.MAX_VALUE)) { amount ->
                Quantity.of(amount).value.toInt() shouldBe amount
            }
        }
}
