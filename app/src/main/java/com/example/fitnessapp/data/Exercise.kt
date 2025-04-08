package com.example.fitnessapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// Data class with the structure of the exercises
data class Exercise(
    val day: Int,
    @StringRes val exerciseName: Int,
    @StringRes val exerciseDescription: Int,
    @DrawableRes val exerciseImage: Int
)