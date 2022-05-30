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
    internal fun testGroupCards() {
        val cards = arrayOf(
            Card(2, Card.CardConstants.SUIT_SPADES),
            Card(3, Card.CardConstants.SUIT_HEARTS),
            Card(3, Card.CardConstants.SUIT_SPADES),
            Card(4, Card.CardConstants.SUIT_CLUBS),
            Card(2, Card.CardConstants.SUIT_HEARTS),
        )
        val hand = Hand(cards)
        print(hand.groupCards())
        val result = hand.groupCards();
        assertEquals(linkedSetOf(2, 3, 4), result.keys)
        assertEquals(2, result[2]!!.count())
        assertEquals(2, result[3]!!.count())
        assertEquals(1, result[4]!!.count())
    }

    @Test
    internal fun testGetRank_StraightFlush() {
        val cards = arrayOf(
            Card(2, Card.CardConstants.SUIT_SPADES),
            Card(3, Card.CardConstants.SUIT_SPADES),
            Card(4, Card.CardConstants.SUIT_SPADES),
            Card(5, Card.CardConstants.SUIT_SPADES),
            Card(6, Card.CardConstants.SUIT_SPADES),
        )
        val hand = Hand(cards)
        assertEquals("9", hand.getRank())
    }
    @Test
    internal fun testGetRank_FourOfAKind() {
        val cards = arrayOf(
            Card(3, Card.CardConstants.SUIT_SPADES),
            Card(3, Card.CardConstants.SUIT_HEARTS),
            Card(3, Card.CardConstants.SUIT_CLUBS),
            Card(3, Card.CardConstants.SUIT_DIAMONDS),
            Card(6, Card.CardConstants.SUIT_SPADES),
        )
        val hand = Hand(cards)
        assertEquals("8", hand.getRank())
    }
    @Test
    internal fun testGetRank_FullHouse() {
        val cards = arrayOf(
            Card(3, Card.CardConstants.SUIT_SPADES),
            Card(3, Card.CardConstants.SUIT_HEARTS),
            Card(3, Card.CardConstants.SUIT_CLUBS),
            Card(6, Card.CardConstants.SUIT_DIAMONDS),
            Card(6, Card.CardConstants.SUIT_SPADES),
        )
        val hand = Hand(cards)
        assertEquals("7", hand.getRank())
    }
    @Test
    internal fun testGetRank_Flush() {
        val cards = arrayOf(
            Card(3, Card.CardConstants.SUIT_SPADES),
            Card(5, Card.CardConstants.SUIT_SPADES),
            Card(7, Card.CardConstants.SUIT_SPADES),
            Card(8, Card.CardConstants.SUIT_SPADES),
            Card(10, Card.CardConstants.SUIT_SPADES),
        )
        val hand = Hand(cards)
        assertEquals("6", hand.getRank())
    }
    @Test
    internal fun testGetRank_Straight() {
        val cards = arrayOf(
            Card(3, Card.CardConstants.SUIT_SPADES),
            Card(4, Card.CardConstants.SUIT_HEARTS),
            Card(5, Card.CardConstants.SUIT_SPADES),
            Card(6, Card.CardConstants.SUIT_SPADES),
            Card(7, Card.CardConstants.SUIT_SPADES),
        )
        val hand = Hand(cards)
        assertEquals("5", hand.getRank())
    }
    @Test
    internal fun testGetRank_ThreeOfAKind() {
        val cards = arrayOf(
            Card(3, Card.CardConstants.SUIT_SPADES),
            Card(3, Card.CardConstants.SUIT_HEARTS),
            Card(3, Card.CardConstants.SUIT_CLUBS),
            Card(6, Card.CardConstants.SUIT_SPADES),
            Card(7, Card.CardConstants.SUIT_SPADES),
        )
        val hand = Hand(cards)
        assertEquals("4", hand.getRank())
    }
    @Test
    internal fun testGetRank_TwoPair() {
        val cards = arrayOf(
            Card(3, Card.CardConstants.SUIT_SPADES),
            Card(3, Card.CardConstants.SUIT_HEARTS),
            Card(6, Card.CardConstants.SUIT_CLUBS),
            Card(6, Card.CardConstants.SUIT_SPADES),
            Card(7, Card.CardConstants.SUIT_SPADES),
        )
        val hand = Hand(cards)
        assertEquals("3", hand.getRank())
    }
    @Test
    internal fun testGetRank_Pair() {
        val cards = arrayOf(
            Card(3, Card.CardConstants.SUIT_SPADES),
            Card(3, Card.CardConstants.SUIT_HEARTS),
            Card(6, Card.CardConstants.SUIT_CLUBS),
            Card(7, Card.CardConstants.SUIT_SPADES),
            Card(8, Card.CardConstants.SUIT_SPADES),
        )
        val hand = Hand(cards)
        assertEquals("2", hand.getRank())
    }
    @Test
    internal fun testGetRank_HighCard() {
        val cards = arrayOf(
            Card(3, Card.CardConstants.SUIT_SPADES),
            Card(4, Card.CardConstants.SUIT_HEARTS),
            Card(6, Card.CardConstants.SUIT_CLUBS),
            Card(7, Card.CardConstants.SUIT_SPADES),
            Card(9, Card.CardConstants.SUIT_SPADES),
        )
        val hand = Hand(cards)
        assertEquals("1", hand.getRank())
    }
}
