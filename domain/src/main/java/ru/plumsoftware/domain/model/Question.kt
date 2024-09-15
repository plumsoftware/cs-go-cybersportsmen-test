package ru.plumsoftware.domain.model

data class Question(
    val question: String = "",
    val answers: List<String> = emptyList()
)
