package ru.plumsoftware.csgotest.presentation.main_screen

import androidx.annotation.DrawableRes
import ru.plumsoftware.domain.model.CyberSportsmen
import ru.plumsoftware.domain.model.Question

data class MainState(
    @DrawableRes val back: Int,
    val questions: List<Question>,
    val currentQuestion: Int,
    val cyberSportsmen: CyberSportsmen = CyberSportsmen.empty()
)