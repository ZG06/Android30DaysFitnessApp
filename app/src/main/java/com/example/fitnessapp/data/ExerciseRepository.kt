package com.example.fitnessapp.data

import com.example.fitnessapp.R

// Collection of the exercises
object ExerciseRepository {
    val exercises = listOf<Exercise>(
        Exercise(1, R.string.exercise_1_name, R.string.exercise_1_description, R.drawable.jumping_jacks),
        Exercise(2, R.string.exercise_2_name, R.string.exercise_2_description, R.drawable.push_ups),
        Exercise(3, R.string.exercise_3_name, R.string.exercise_3_description, R.drawable.bodyweight_squats),
        Exercise(4, R.string.exercise_4_name, R.string.exercise_4_description, R.drawable.plank_hold),
        Exercise(5, R.string.exercise_5_name, R.string.exercise_5_description, R.drawable.high_knees),
        Exercise(6, R.string.exercise_6_name, R.string.exercise_6_description, R.drawable.glute_bridges),
        Exercise(7, R.string.exercise_7_name, R.string.exercise_7_description, R.drawable.triceps_dips_on_chair),
        Exercise(8, R.string.exercise_8_name, R.string.exercise_8_description, R.drawable.mountain_climbers),
        Exercise(9, R.string.exercise_9_name, R.string.exercise_9_description, R.drawable.wall_sit),
        Exercise(10, R.string.exercise_10_name, R.string.exercise_10_description, R.drawable.side_plank)
    )
}