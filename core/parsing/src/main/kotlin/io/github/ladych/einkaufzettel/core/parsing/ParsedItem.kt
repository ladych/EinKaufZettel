package io.github.ladych.einkaufzettel.core.parsing

import io.github.ladych.einkaufzettel.core.domain.Quantity

/** One shopping list entry recognised in spoken or typed text, before it is added to a list. */
public data class ParsedItem(
    public val name: String,
    public val quantity: Quantity? = null,
)
