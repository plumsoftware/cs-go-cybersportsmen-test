package ru.plumsoftware.csgotest.presentation.general.store

sealed class GeneralIntent {
    data class ChangeAppOpenLoadingState(val isLoading: Boolean) : GeneralIntent()
}