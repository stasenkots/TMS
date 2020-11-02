package com.example.tms

import kotlinx.coroutines.*

fun launchIO(task: suspend () -> Unit) =
    CoroutineScope(Dispatchers.IO).launch {
        task()
    }

fun launchUI(task: suspend () -> Unit) =
    CoroutineScope(Dispatchers.Main).launch {
        task()
    }
suspend fun launchAsync(task: suspend () -> Unit)=
    CoroutineScope(Dispatchers.IO).async{
    task()
}

