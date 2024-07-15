package ru.prike.otus_coroutines.one

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch {
            delay(1000L)
            println("Coroutines!")
        }
        launch {
            delay(500L)
            println("World")
        }
        println("Hello,")
    }
    println("Done")
}