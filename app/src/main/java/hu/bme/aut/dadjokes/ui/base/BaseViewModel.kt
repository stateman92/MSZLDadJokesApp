package hu.bme.aut.dadjokes.ui.base

import androidx.lifecycle.ViewModel
import hu.bme.aut.dadjokes.common.print

open class BaseViewModel: ViewModel() {
    init {
        "$this is created".print()
    }
}