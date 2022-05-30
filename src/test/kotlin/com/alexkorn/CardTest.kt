package com.alexkorn

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CardTest {
    @Test
    internal fun testRender() {
        val card = Card(1, Card.CardConstants.SUIT_CLUBS)
        val result = card.render()
        assertEquals("Ace of Clubs", result)
    }
}
