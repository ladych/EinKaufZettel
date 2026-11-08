package io.github.ladych.einkaufzettel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import io.github.ladych.einkaufzettel.core.designsystem.EinKaufZettelTheme
import io.github.ladych.einkaufzettel.navigation.EinKaufZettelNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            EinKaufZettelTheme {
                EinKaufZettelNavigation()
            }
        }
    }
}
