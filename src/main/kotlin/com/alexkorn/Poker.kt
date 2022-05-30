package com.alexkorn

class Poker {
    fun doAThing(input: Int): Int = input * 2
}

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello world!")
        println(Poker().doAThing(args[0].toInt()))
    }
}
