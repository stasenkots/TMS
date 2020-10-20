package com.example.tms.EightHW.Database

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun launchIO(task: suspend () -> Unit) =
    CoroutineScope(Dispatchers.IO).launch {
        task()
    }

fun launchUI(task: suspend () -> Unit) =
    CoroutineScope(Dispatchers.Main).launch {
        task()
    }

