package com.alexkorn

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello world!")
        println(Poker().doAThing(args[0].toInt()))
    }
}
