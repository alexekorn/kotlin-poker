package com.alexkorn

class Card(private val rank: Int, private val suit: String) {
    object CardConstants {
        const val SUIT_CLUBS = "clubs"
        const val SUIT_DIAMONDS = "diamonds"
        const val SUIT_HEARTS = "hearts"
        const val SUIT_SPADES = "spades"
    }

    fun render(): String {
        val rankMap = HashMap<Int, String>()
        rankMap[1] = "Ace"
        rankMap[11] = "Jack"
        rankMap[12] = "Queen"
        rankMap[13] = "King"

        val suitMap = HashMap<String, String>()
        suitMap[CardConstants.SUIT_CLUBS] = "Clubs"
        suitMap[CardConstants.SUIT_DIAMONDS] = "Diamonds"
        suitMap[CardConstants.SUIT_HEARTS] = "Hearts"
        suitMap[CardConstants.SUIT_SPADES] = "Spades"

        var result = ""
        result = if (rankMap.containsKey(rank)) {
            result.plus(rankMap[rank])
        } else {
            result.plus(rank)
        }
        result = result.plus(" of ")
        result = result.plus(suitMap[suit])
        return result
    }

    /**
     * TODO how to handle Ace?
     */
    fun getRank(): Int {
        return rank
    }

    fun getSuit(): String? {
        return suit
    }
}
