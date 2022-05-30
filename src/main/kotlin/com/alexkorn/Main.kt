package com.alexkorn

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello world!")
        print(Poker().createDeck().renderCards())
    }
}
