package com.robfed.petcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.robfed.petcare.ui.theme.PetCareTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainPage()
        }
    }

    @Composable
    fun MainPage() {
        Content(state = viewModel.uiState.collectAsState().value)
    }
}

@Composable
fun Content(state: String) {
    PetCareTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            when (state) {
                "A" -> LoadingScreen()
                "B"-> ReadyScreen()
                else-> ErrorScreen()
            }
        }
    }
}


@Composable
fun LoadingScreen() {
    Text(text = "Loading Screen")
}

@Composable
fun ReadyScreen() {
    Text(text = "Ready Screen")
}

@Composable
fun ErrorScreen() {
    Text(text = "Error Screen")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PetCareTheme {
        Content(state = "B")
    }
}