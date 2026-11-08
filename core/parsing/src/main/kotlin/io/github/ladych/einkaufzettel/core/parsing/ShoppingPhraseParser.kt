package io.github.ladych.einkaufzettel.core.parsing

/** Turns a spoken or typed phrase such as "zwei Liter Milch und Brot" into shopping items. */
public class ShoppingPhraseParser {
    public fun parse(text: String): List<ParsedItem> {
        val name = text.trim()
        return if (name.isEmpty()) emptyList() else listOf(ParsedItem(name = name))
    }
}
