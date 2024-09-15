package ru.plumsoftware.csgotest.presentation.main_screen.store

import androidx.annotation.DrawableRes
import ru.plumsoftware.domain.model.CyberSportsmen
import ru.plumsoftware.domain.model.Question

data class MainState(
    @DrawableRes val back: Int,
    val questions: Sequence<Question>,
    val currentQuestion: Int,
    val cyberSportsmen: CyberSportsmen = CyberSportsmen.empty(),
    val isFinish: Boolean = false,
    val isVisibleText: Boolean = true
)