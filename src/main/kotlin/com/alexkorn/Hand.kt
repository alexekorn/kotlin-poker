package com.alexkorn

import java.lang.IllegalArgumentException

/**
 * A hand of 5 cards.
 */
class Hand(private val cards: Array<Card>) {
    init {
        if (cards.count() != 5) {
            throw IllegalArgumentException("A hand must have 5 cards")
        }
        cards.sortBy { it.getRank() }
    }

    /**
     * https://www.poker.org/poker-hands-ranking-chart/
     *
     * For our purposes, we'll consider
     * 9. Straight flush (royal flush is just this with high card)
     * 8. Four of a kind
     * 7. Full house
     * 6. Flush
     * 5. Straight
     * 4. Three of a kind
     * 3. Two pair
     * 2. Pair
     * 1. High card
     */
    fun getRank(): String {


        // TODO
        return "1.1"
    }

    fun isFlush(): Boolean {
        var lastSuit: String? = null
        for (card in cards) {
            if (lastSuit == null) {
                lastSuit = card.getSuit()
                continue
            }
            if (card.getSuit() != lastSuit) {
                return false
            }
            lastSuit = card.getSuit()
        }
        return true
    }
    fun isStraight(): Boolean {
        var lastRank: Int? = null
        for (card in cards) {
            if (lastRank == null) {
                lastRank = card.getRank()
                continue
            }
            if (card.getRank() != lastRank + 1) {
                return false
            }
            lastRank = card.getRank()
        }
        return true
    }
}
