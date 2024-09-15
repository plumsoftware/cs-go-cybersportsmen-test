package ru.plumsoftware.csgotest.presentation.main_screen

sealed class MainScreenIntent {
    data object QuestionClick : MainScreenIntent()
}