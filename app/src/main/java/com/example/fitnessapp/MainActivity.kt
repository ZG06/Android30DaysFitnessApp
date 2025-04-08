package com.example.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.fitnessapp.data.ExerciseRepository
import com.example.fitnessapp.ui.theme.FitnessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    FitnessApp()
                }
            }
        }
    }
}

// Showing the list of all exercises
@Composable
fun FitnessApp() {
    Scaffold(
        topBar = {
            FitnessAppTopBar()
        }
    ) { it ->
        ExerciseItem(
            ExerciseRepository.exercises,
            contentPadding = it
        )
    }
}

// Application top bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessAppTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}