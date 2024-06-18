package uk.govuk.responsivetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass
import uk.govuk.responsivetest.ui.theme.ResponsiveTestTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResponsiveTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    Greeting(modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier = Modifier.padding(16.dp)) {
        when (this.maxWidth) {
            in (0.dp..600.dp) -> {
                Column(
                    modifier = Modifier.fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    HeroImage()

                    HeadingText()
                    BodyText()

                    Row() {
                        ProgressDot()
                        ProgressDot(true)
                        ProgressDot()
                    }

                    ContinueButton()
                    SkipButton()
                }
            }
            in (601.dp..900.dp) -> {
                Row(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Column() {
                        HeroImage(landscape = true)
                    }

                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        HeadingText()
                        BodyText()
                        Row() {
                            ProgressDot()
                            ProgressDot(true)
                            ProgressDot()
                        }

                        ContinueButton()
                        SkipButton()
                    }
                }
            }
        }
    }
}


@Composable
private fun HeroImage(landscape: Boolean = false) {
    var resourceId = R.drawable.green_sea_turtle_8199770_1280
    if (landscape) {
        resourceId = R.drawable.waves_3473335_1280
    }

    Image(
        painterResource(id = resourceId),
        contentDescription = "Image",
        modifier = Modifier
            .padding(64.dp)
            .height(400.dp)
    )
}

@Composable
private fun HeadingText() {
    Text(
        text = "Hello World!",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
private fun BodyText() {
    Text(
        text = "This is a demo screen that attempts to show how to use adaptive/responsive design in Android",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyLarge,
    )
}

@Composable
private fun ProgressDot(selected: Boolean = false) {
    val dotType = if (selected) {
        R.drawable.baseline_circle_24
    } else {
        R.drawable.outline_circle_24
    }

    Image(
        painterResource(id = dotType),
        contentDescription = "Dot",
        modifier = Modifier
            .padding(8.dp)
            .size(24.dp),
    )
}

@Composable
private fun ContinueButton() {
    Row() {
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.weight(1f)
                .padding(16.dp)
        ) {
            Text(text = "Continue")
        }
    }
}

@Composable
private fun SkipButton() {
    Row() {
        TextButton(onClick = { /* TODO */ }) {
            Text("Skip")
        }
    }
}
