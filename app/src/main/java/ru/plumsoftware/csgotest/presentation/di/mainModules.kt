package ru.plumsoftware.csgotest.presentation.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.plumsoftware.back.BackRepositoryImpl
import ru.plumsoftware.data.repository.CyberSportsmenRepositoryImpl
import ru.plumsoftware.data.repository.QuestionsRepositoryImpl
import ru.plumsoftware.domain.repository.BackRepository
import ru.plumsoftware.domain.repository.CyberSportsmenRepository
import ru.plumsoftware.domain.repository.QuestionsRepository

val mainModules = module {
    singleOf(::QuestionsRepositoryImpl).bind<QuestionsRepository>()
    singleOf(::BackRepositoryImpl).bind<BackRepository>()
    singleOf(::CyberSportsmenRepositoryImpl).bind<CyberSportsmenRepository>()
}