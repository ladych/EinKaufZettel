package io.github.ladych.einkaufzettel.core.domain

import java.math.BigDecimal

/**
 * A positive amount, e.g. 2 or 1.5.
 *
 * Backed by [BigDecimal] instead of [Double] so that amounts stay exact. Trailing zeros are stripped,
 * which makes `Quantity.of("2.0")` equal to `Quantity.of(2)`.
 */
@JvmInline
public value class Quantity private constructor(
    public val value: BigDecimal,
) {
    override fun toString(): String = value.toPlainString()

    public companion object {
        public fun of(value: Int): Quantity = of(BigDecimal(value))

        public fun of(value: String): Quantity = of(BigDecimal(value))

        public fun of(value: BigDecimal): Quantity {
            require(value.signum() > 0) { "A quantity must be positive, but was $value" }
            return Quantity(value.stripTrailingZeros())
        }
    }
}
