package com.example.fitnessapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitnessapp.data.Exercise
import com.example.fitnessapp.ui.theme.FitnessAppTheme


// Scrollable column with multiple Card composables
@Composable
fun ExerciseItem(
    exerciseList: List<Exercise>,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(contentPadding = contentPadding) {
        items(exerciseList) { it ->
            ExerciseListItem(
                exercise = it,
                modifier = Modifier.padding(
                    start = dimensionResource(R.dimen.card_start_end_padding),
                    end = dimensionResource(R.dimen.card_start_end_padding),
                    top = dimensionResource(R.dimen.card_top_bottom_padding),
                    bottom = dimensionResource(R.dimen.card_top_bottom_padding),
                )
            )
        }
    }
}

// A single Card composable
@Composable
fun ExerciseListItem(
    exercise: Exercise,
    modifier: Modifier = Modifier
) {
    // Checks whether the description is expanded
    var expanded by remember { mutableStateOf(false) }

    // Card composable
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.card_elevation)
        ),
        modifier = modifier
    ) {
        // Column with the day number, exercise image, and exercise name and description
        Column(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            // Day number
            Text(
                text = stringResource(R.string.day_number, exercise.day),
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_small))
            )
            // Exercise icon
            ExerciseIcon(
                exercise.exerciseImage
            )
            // Row with the exercise name and description
            Row(
                modifier = Modifier.padding(
                    top = dimensionResource(R.dimen.padding_small)
                )
            ) {
                // Exercise Name
                ExerciseName(
                    R.string.exercise_header,
                    exercise.exerciseName
                )
                // Spacer between the exercise name and the 'Expand' icon
                Spacer(modifier = Modifier.weight(1f))
                // 'Expand' button
                ExerciseItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
            }
            // Shows the description if the 'expanded' variable is set to true
            if (expanded) {
                ExerciseDescription(
                    R.string.description_header,
                    exercise.exerciseDescription
                )
            }
        }
    }
}

@Composable
fun ExerciseIcon(
    @DrawableRes exerciseIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(exerciseIcon),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = dimensionResource(R.dimen.padding_small)
            )
    )
}

@Composable
fun ExerciseName(
    @StringRes exerciseHeader: Int,
    @StringRes exerciseName: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(exerciseHeader),
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = stringResource(exerciseName),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
        )
    }
}

@Composable
fun ExerciseDescription(
    @StringRes descriptionHeader: Int,
    @StringRes exerciseDescription: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(descriptionHeader),
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = stringResource(exerciseDescription),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
        )
    }
}

// Creating the 'Expand' button and it's logic
@Composable
private fun ExerciseItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ExercisePreview() {
    FitnessAppTheme {
        FitnessApp()
    }
}