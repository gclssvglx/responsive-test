package uk.govuk.responsivetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(id = R.drawable.green_sea_turtle_8199770_1280),
            contentDescription = "Image",
            modifier = Modifier.padding(16.dp).height(400.dp)
        )

        Text(
            text = "Hello World!",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge,
        )

        Text(
            text = "This is a demo screen show how to use adaptive/responsive design in Android",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
        )

        Row() {
            Button(
                onClick = { /* TODO */ },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.padding(16.dp)
                    .size(32.dp)
            ) {}
            Button(
                onClick = { /* TODO */ },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                modifier = Modifier.padding(16.dp)
                    .size(32.dp)
            ) {}
            Button(
                onClick = { /* TODO */ },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.padding(16.dp)
                    .size(32.dp)
            ) {}
        }

        TextButton(
            onClick = { /* TODO */ }
        ) {
            Text("Skip")
        }
    }
}

