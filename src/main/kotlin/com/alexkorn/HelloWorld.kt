package com.alexkorn

class HelloWorld {
    fun doAThing(input: Int): Int = input * 2

}

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello world!")
        println(HelloWorld().doAThing(args[0].toInt()))
    }
}