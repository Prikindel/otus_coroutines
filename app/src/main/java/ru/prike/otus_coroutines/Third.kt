package ru.prike.otus_coroutines

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import kotlin.system.measureTimeMillis

//fun main() {
//    runBlocking {
//        launch {
//            delay(600)
//            println("Launch 1 done")
//        }
//        launch {
//            delay(600)
//            println("Launch 2 done")
//        }
//        println("Wait finish coroutines")
//    }
//}

//fun main() {
//    runBlocking {
//        val time = measureTimeMillis {
//            val name = getFirstName()
//            val secondName = getSecondName()
//            println("User - $name $secondName")
//        }
//        println("time = $time")
//    }
//}

suspend fun getFirstName(): String {
    delay(600)
    return "Kotlin"
}

suspend fun getSecondName(): String {
    delay(300)
    return "Coroutine"
}

//fun main() {
//    runBlocking {
//        val time = measureTimeMillis {
//            val job: Job = launch { delay(1000) }
//            val name: Deferred<String> = async { getFirstName() }
//            val secondName = async { getSecondName() }
//            println("User - ${name.await()} ${secondName.await()}")
//
//            listOf(
//                async {
//                    1
//                },
//                async { 2 }
//            ).awaitAll()
//        }
//        println("time = $time")
//    }
//}

// ==================

fun main() {
    runBlocking {
        launch {
            repeat(5) {
                println("Coroutine A: $it")
                yield() // Приостанавливаем текущую корутину
            }
        }
        launch {
            repeat(5) {
                println("Coroutine B: $it")
                yield() // Приостанавливаем текущую корутину
            }
        }
    }
}