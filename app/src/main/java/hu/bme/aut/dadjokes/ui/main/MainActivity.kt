package hu.bme.aut.dadjokes.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    @VisibleForTesting
    internal val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }
}