package ru.mavrinvladislav.jetpack.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.mavrinvladislav.jetpack.domain.entity.TimeFrame
import ru.mavrinvladislav.jetpack.domain.use_case.LoadBarUseCase
import javax.inject.Inject

class TerminalViewModel @Inject constructor(
    private val loadBarUseCase: LoadBarUseCase
) : ViewModel() {

    private val _screenState: MutableStateFlow<TerminalScreenState> =
        MutableStateFlow(TerminalScreenState.Initial)
    val screenState = _screenState.asStateFlow()

    private var lastState: TerminalScreenState = TerminalScreenState.Initial

    init {
        loadBarList(TimeFrame.MIN_30)
    }

    fun loadBarList(timeFrame: TimeFrame) {
        lastState = _screenState.value
        _screenState.value = TerminalScreenState.Loading
        viewModelScope.launch {
            loadBarUseCase(timeFrame).fold(
                onSuccess = {
                    _screenState.value = TerminalScreenState.Content(it, timeFrame)
                },
                onFail = {
                    _screenState.value = lastState
                }
            )
        }
    }
}