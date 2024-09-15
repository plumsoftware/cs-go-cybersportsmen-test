package ru.plumsoftware.domain.model

data class CyberSportsmen(
    val name: String = "",
    val money: Long = 0L,
    val icon: Int = 0
) {
    companion object {
        fun empty() : CyberSportsmen = CyberSportsmen()
    }
}
