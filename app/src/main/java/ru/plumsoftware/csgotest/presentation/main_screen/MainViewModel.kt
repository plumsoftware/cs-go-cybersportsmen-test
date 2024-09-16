package ru.plumsoftware.csgotest.presentation.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.plumsoftware.csgotest.presentation.main_screen.store.MainScreenIntent
import ru.plumsoftware.csgotest.presentation.main_screen.store.MainState
import ru.plumsoftware.domain.repository.BackRepository
import ru.plumsoftware.domain.repository.CyberSportsmenRepository
import ru.plumsoftware.domain.repository.QuestionsRepository

class MainViewModel(
    private val questionsRepository: QuestionsRepository,
    private val cyberSportsmenRepository: CyberSportsmenRepository,
    backRepository: BackRepository
) : ViewModel() {

    val state = MutableStateFlow(
        MainState(
            back = backRepository.getBack(),
            questions = questionsRepository.getQuestions().asSequence(),
            currentQuestion = 0
        )
    )

    fun onIntent(intent: MainScreenIntent) {

        when (intent) {
            MainScreenIntent.AnswerClick -> {

                viewModelScope.launch {
                    state.update {
                        it.copy(isVisibleText = false)
                    }
                    delay(100)
                    state.update {
                        it.copy(isVisibleText = true)
                    }
                }

                val currentQuestion = state.value.currentQuestion + 1
                if (currentQuestion <= state.value.questions.count() - 1)
                    state.update {
                        it.copy(
                            currentQuestion = currentQuestion
                        )
                    }
                else
                    state.update {
                        it.copy(
                            isFinish = true,
                            isVisibleButtons = false,
                            cyberSportsmen = cyberSportsmenRepository.getRandomPlayer()
                        )
                    }
            }

            MainScreenIntent.RetryClick -> {
                state.update {
                    it.copy(
                        isFinish = false,
                        currentQuestion = 0,
                        isVisibleButtons = true,
                        questions = questionsRepository.getQuestions().asSequence()
                    )
                }
            }
        }
    }
}