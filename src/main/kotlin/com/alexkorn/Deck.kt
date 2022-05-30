package com.alexkorn

/**
 * A deck of cards.
 *
 * This is a standard 52-card deck:
 * https://en.wikipedia.org/wiki/Standard_52-card_deck
 */
class Deck() {
    private var cards = ArrayList<Card>()

    init {
        val suits = arrayOf(
            Card.CardConstants.SUIT_CLUBS,
            Card.CardConstants.SUIT_DIAMONDS,
            Card.CardConstants.SUIT_HEARTS,
            Card.CardConstants.SUIT_SPADES,
        )
        for (rankIter in 1..13) {
            for (suitIter in suits) {
                cards.add(Card(rankIter, suitIter))
            }
        }
    }

    fun renderCards(): String {
        var result = ""
        for (card in cards) {
            result = result.plus(card.render()).plus("\n")
        }
        return result
    }
}
