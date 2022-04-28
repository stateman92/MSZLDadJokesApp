package hu.bme.aut.dadjokes.ui.main

import android.R.id
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import hu.bme.aut.dadjokes.ui.Screen


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseAnalytics = Firebase.analytics

        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "MainActivity")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "MainActivity")
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "view")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, bundle)

        setContent {
            MaterialTheme {
                Screen()
            }
        }
    }
}