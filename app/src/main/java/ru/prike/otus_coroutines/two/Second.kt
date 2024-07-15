package ru.prike.otus_coroutines.two

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//fun main() {
//    runBlocking {
//        val job = launch {
//            delay(1000L)
//            println("Coroutines!")
//        }
//        println("Hello,")
//        job.join()
//        println("Done")
//    }
//}

fun main() {
    runBlocking {
        val job = SupervisorJob()
        val scope = CoroutineScope(job)
        scope.launch {
            delay(300)
            throw Exception("Launch 1 is error")
        }
        scope.launch {
            delay(1000)
            println("Launch 2 done")
        }
        println("Wait finish coroutines")
        job.join()
    }
}