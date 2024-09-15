package ru.plumsoftware.csgotest.presentation.main_screen.store

sealed class MainScreenIntent {
    data object AnswerClick : MainScreenIntent()
    data object RetryClick : MainScreenIntent()
}