package ru.plumsoftware.csgotest.presentation.general.store

sealed class GeneralLabel {
    data object DismissDialog : GeneralLabel()
    data object ShowDialog : GeneralLabel()
}