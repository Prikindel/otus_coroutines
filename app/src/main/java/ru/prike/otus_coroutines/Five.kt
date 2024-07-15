package ru.prike.otus_coroutines

import android.view.View
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext

//fun main() {
//    runBlocking {
//        launch(Dispatchers.Default) {
//            println("Default dispatcher: ${Thread.currentThread().name}")
//        }
//        launch(Dispatchers.IO) {
//            println("IO dispatcher: ${Thread.currentThread().name}")
//        }
//        launch(newSingleThreadContext("MyName")) {
//            println("My dispatcher: ${Thread.currentThread().name}")
//        }
//        launch {
//            println("Other dispatcher: ${Thread.currentThread().name}")
//        }
//    }
//}

//fun main() {
//    runBlocking {
//        println("dispatcher: ${Thread.currentThread().name}")
//        withContext(Dispatchers.IO) {
//            println("IO dispatcher: ${Thread.currentThread().name}")
//        }
//        println("dispatcher: ${Thread.currentThread().name}")
//
//        val view: TextView
//
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                delay(10000)
//            }
//
//        }
//
//        lifecycleScope.launch {
//
//        }
//
//        launch(Dispatchers.IO) {
//            val name = getFirstName()
//            withContext(Dispatchers.Main) {
//                view.text = name
//            }
//        }
//    }
//}

fun main() {
    runBlocking {
        println("dispatcher: ${Thread.currentThread().name}")
        withContext(Dispatchers.Unconfined) {
            println("Unconfined dispatcher: ${Thread.currentThread().name}")
            unconfind()
            println("Unconfined dispatcher: ${Thread.currentThread().name}")
        }
        println("dispatcher: ${Thread.currentThread().name}")
    }
}

suspend fun unconfind() {
    delay(10)
    println("Unconfined dispatcher: ${Thread.currentThread().name}")
}