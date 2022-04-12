package hu.bme.aut.dadjokes.ui.base

import androidx.lifecycle.ViewModel
import hu.bme.aut.dadjokes.extensions.print

open class BaseViewModel : ViewModel() {
    init {
        "$this is created".print()
    }
}