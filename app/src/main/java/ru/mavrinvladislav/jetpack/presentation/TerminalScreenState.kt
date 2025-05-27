package ru.mavrinvladislav.jetpack.presentation

import ru.mavrinvladislav.jetpack.domain.entity.Bar
import ru.mavrinvladislav.jetpack.domain.entity.TimeFrame

sealed class TerminalScreenState {

    data object Initial : TerminalScreenState()
    data object Loading : TerminalScreenState()

    data class Content(val list: List<Bar>, val timeFrame: TimeFrame) : TerminalScreenState()
    data class Error(val message: String) : TerminalScreenState()
}