package ru.mavrinvladislav.jetpack.common

import java.util.Calendar
import java.util.Date

fun Long.toCalendar() = Calendar.getInstance().apply {
    time = Date(this@toCalendar)
}