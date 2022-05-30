package com.alexkorn

import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

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

    @Test
    internal fun testIsFlush_True() {
        val cards = arrayOf(
            Card(2, Card.CardConstants.SUIT_SPADES),
            Card(3, Card.CardConstants.SUIT_SPADES),
            Card(4, Card.CardConstants.SUIT_SPADES),
            Card(5, Card.CardConstants.SUIT_SPADES),
            Card(6, Card.CardConstants.SUIT_SPADES),
        )
        val hand = Hand(cards)
        assertTrue(hand.isFlush())
    }
    @Test
    internal fun testIsFlush_False() {
        val cards = arrayOf(
            Card(2, Card.CardConstants.SUIT_SPADES),
            Card(3, Card.CardConstants.SUIT_SPADES),
            Card(4, Card.CardConstants.SUIT_SPADES),
            Card(5, Card.CardConstants.SUIT_SPADES),
            Card(6, Card.CardConstants.SUIT_HEARTS),
        )
        val hand = Hand(cards)
        assertFalse(hand.isFlush())
    }

    @Test
    internal fun testIsStraight_True() {
        val cards = arrayOf(
            Card(2, Card.CardConstants.SUIT_SPADES),
            Card(3, Card.CardConstants.SUIT_HEARTS),
            Card(4, Card.CardConstants.SUIT_CLUBS),
            Card(5, Card.CardConstants.SUIT_SPADES),
            Card(6, Card.CardConstants.SUIT_SPADES),
        )
        val hand = Hand(cards)
        assertTrue(hand.isStraight())
    }
    @Test
    internal fun testIsStraight_False() {
        val cards = arrayOf(
            Card(2, Card.CardConstants.SUIT_SPADES),
            Card(3, Card.CardConstants.SUIT_SPADES),
            Card(4, Card.CardConstants.SUIT_SPADES),
            Card(5, Card.CardConstants.SUIT_SPADES),
            Card(7, Card.CardConstants.SUIT_HEARTS),
        )
        val hand = Hand(cards)
        assertFalse(hand.isStraight())
    }

    @Test
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
