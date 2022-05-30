package com.alexkorn

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class DeckTest {
    @Test
    internal fun testRenderCards() {
        var result = Deck().renderCards()
        assertTrue(result.contains("Ace of Hearts\n"))
    }
}
