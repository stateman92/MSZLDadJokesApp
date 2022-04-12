package hu.bme.aut.dadjokes.extensions

import android.util.Log

fun String.print(tag: String = "DADJOKES") {
    Log.d(tag, this)
}