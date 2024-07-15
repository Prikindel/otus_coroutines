package ru.prike.otus_coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun mai1n() {
    runBlocking {
        val job = launch {
            repeat(1000000) {
                println("Iteration $it")
                delay(0)
            }
        }
        delay(1)
        println("Cancel job")
        job.cancel()
        job.join()
        println("end")
    }
}

fun main1() {
    runBlocking {
        val job = launch(Dispatchers.IO) {
            repeat(100) {
                println("Iteration $it")
                Thread.sleep(500)
            }
        }
        delay(2000)
        println("Cancel job")
        job.cancelAndJoin()
        println("end")
    }
}

fun main() {
    runBlocking {
        val job = launch(Dispatchers.IO) {
            var i = 0
            repeat(100) {
                ensureActive()
                println("Iteration $it")
                Thread.sleep(500)
            }
        }
        delay(2000)
        println("Cancel job")
        job.cancelAndJoin()
        println("end")
    }
}