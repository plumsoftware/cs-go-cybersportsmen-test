package ru.plumsoftware.csgotest.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.plumsoftware.csgotest.presentation.main_screen.MainViewModel

val viewModelModule = module {
    viewModelOf(::MainViewModel)
}