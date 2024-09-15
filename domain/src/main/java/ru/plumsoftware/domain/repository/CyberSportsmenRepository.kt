package ru.plumsoftware.domain.repository

import ru.plumsoftware.domain.model.CyberSportsmen

fun interface CyberSportsmenRepository {
    fun getRandomPlayer() : CyberSportsmen
}