package ru.plumsoftware.domain.repository

import ru.plumsoftware.domain.model.Question

fun interface QuestionsRepository {
    fun getQuestions() : List<Question>
}