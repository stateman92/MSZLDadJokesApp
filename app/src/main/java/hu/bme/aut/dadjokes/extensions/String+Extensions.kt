package hu.bme.aut.dadjokes.common

import android.util.Log

fun String.print(tag: String = "DADJOKES") {
    Log.d(tag, this)
}