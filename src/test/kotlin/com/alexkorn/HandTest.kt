package com.alexkorn

import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class HandTest {
    @Test
    internal fun testInitRequires5() {
        val cards = arrayOf(
            Card(2, Card.CardConstants.SUIT_SPADES),
            Card(3, Card.CardConstants.SUIT_SPADES),
            Card(4, Card.CardConstants.SUIT_SPADES),
            Card(5, Card.CardConstants.SUIT_SPADES),
        )
        assertFailsWith<IllegalArgumentException> {
            Hand(cards)
        }
    }
    internal fun testGetRank() {
        val cards = arrayOf(
            Card(2, Card.CardConstants.SUIT_SPADES),
            Card(3, Card.CardConstants.SUIT_SPADES),
            Card(4, Card.CardConstants.SUIT_SPADES),
            Card(5, Card.CardConstants.SUIT_SPADES),
            Card(6, Card.CardConstants.SUIT_SPADES),
        )
        val hand = Hand(cards)
        assertEquals("1.1", hand.getRank())
    }
}
