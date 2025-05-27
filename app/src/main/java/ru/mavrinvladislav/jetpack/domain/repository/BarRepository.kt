package ru.mavrinvladislav.jetpack.domain.repository

import ru.mavrinvladislav.jetpack.common.Either
import ru.mavrinvladislav.jetpack.domain.entity.Bar
import ru.mavrinvladislav.jetpack.domain.entity.TimeFrame

interface BarRepository {

    suspend fun loadBars(timeFrame: TimeFrame): Either<List<Bar>, String>
}