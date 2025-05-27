package ru.mavrinvladislav.jetpack.data

import ru.mavrinvladislav.jetpack.common.toCalendar
import ru.mavrinvladislav.jetpack.data.remote.model.BarDto
import ru.mavrinvladislav.jetpack.domain.entity.Bar

fun BarDto.toEntity() = Bar(
    open = open,
    close = close,
    low = low,
    high = high,
    time = time.toCalendar()
)

