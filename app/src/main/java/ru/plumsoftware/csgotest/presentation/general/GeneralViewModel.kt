package ru.plumsoftware.csgotest.presentation.general

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import ru.plumsoftware.csgotest.presentation.general.store.GeneralIntent
import ru.plumsoftware.csgotest.presentation.general.store.GeneralLabel

class GeneralViewModel : ViewModel() {
    val label = MutableSharedFlow<GeneralLabel>()

    fun onIntent(intent: GeneralIntent) {
        when (intent) {
            is GeneralIntent.ChangeAppOpenLoadingState -> {
                viewModelScope.launch {
                    if (intent.isLoading) {
                        label.emit(GeneralLabel.ShowDialog)
                    } else {
                        label.emit(GeneralLabel.DismissDialog)
                    }
                }
            }
        }
    }
}