package ru.prike.otus_coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//fun main() {
//    runBlocking {
//        launch {
//            try {
//                throw RuntimeException("Exception inside coroutine")
//            } catch (e: Exception) {
//                println("Caught exception: ${e.message}")
//            }
//        }
//        println("Coroutine launched")
//    }
//}

//fun main() {
//    runBlocking {
//        try {
//            launch {
//                throw RuntimeException("Exception inside coroutine")
//            }
//        } catch (e: Exception) {
//            println("Caught exception: ${e.message}")
//        }
//        println("Coroutine launched")
//    }
//}

//fun main() {
//    runBlocking {
//        try {
//            coroutineScope {
//                launch {
//                    throw RuntimeException("Exception inside coroutine")
//                }
//            }
//        } catch (e: Exception) {
//            println("Caught exception: ${e.message}")
//        }
//        println("Coroutine launched")
//    }
//}

//fun main() {
//    runBlocking {
//        val result = async {
//            try {
//                getName()
//            } catch (e: Exception) {
//                println("Caught exception: ${e.message}")
//                "error"
//            }
//        }
//        println(result.await())
//        println("Coroutine launched")
//    }
//}

suspend fun getName(): String {
    delay(500)
    throw RuntimeException("Exception inside coroutine")
}

//fun main() {
//    runBlocking {
//        val deferred = GlobalScope.async {
//            throw RuntimeException("Exception inside async")
//        }
//
//        try {
//            deferred.await()
//        } catch (e: Exception) {
//            println("Caught exception: ${e.message}")
//        }
//    }
//}

//fun main() {
//    runBlocking {
//        val handler = CoroutineExceptionHandler { _, exception ->
//            println("Caught $exception")
//        }
//
//        val job = GlobalScope.launch(handler) {
//            launch {
//                delay(100)
//                println("1")
//            }
//            launch {
//                delay(50)
//                throw RuntimeException("Exception inside coroutine")
//            }
//        }
//        job.join()
//    }
//}

fun main() {
    runBlocking {
        val handler = CoroutineExceptionHandler { _, exception ->
            println("Caught $exception")
        }
        val supervisor = SupervisorJob()
        val scope = CoroutineScope(Dispatchers.Default + supervisor)

        scope.launch(handler) {
            throw RuntimeException("Exception in coroutine 1")
        }

        scope.launch(handler) {
            delay(1000L)
            println("Coroutine 2 is still running")
        }

        delay(2000L)
    }
}