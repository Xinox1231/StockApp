package ru.mavrinvladislav.jetpack.domain.use_case

import ru.mavrinvladislav.jetpack.domain.repository.BarRepository
import ru.mavrinvladislav.jetpack.domain.entity.TimeFrame
import javax.inject.Inject

class LoadBarUseCase @Inject constructor(
    private val repository: BarRepository
) {
    suspend operator fun invoke(timeFrame: TimeFrame) = repository.loadBars(timeFrame)
}