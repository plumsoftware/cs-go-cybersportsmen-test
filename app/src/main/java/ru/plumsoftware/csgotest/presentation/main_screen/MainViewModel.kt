package ru.plumsoftware.csgotest.presentation.main_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import ru.plumsoftware.domain.repository.BackRepository
import ru.plumsoftware.domain.repository.CyberSportsmenRepository
import ru.plumsoftware.domain.repository.QuestionsRepository

class MainViewModel(
    questionsRepository: QuestionsRepository,
    private val cyberSportsmenRepository: CyberSportsmenRepository,
    backRepository: BackRepository
) : ViewModel() {

    val state = MutableStateFlow(
        MainState(
            back = backRepository.getBack(),
            questions = questionsRepository.getQuestions(),
            currentQuestion = 0
        )
    )

    fun onIntent(intent: MainScreenIntent) {
        when (intent) {
            MainScreenIntent.QuestionClick -> {
                state.update {
                    it.copy(
                        currentQuestion = state.value.currentQuestion + 1
                    )
                }
            }
        }
    }

}