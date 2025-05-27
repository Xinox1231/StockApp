package ru.mavrinvladislav.jetpack.domain.entity

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize
import java.util.Calendar

@Immutable
@Parcelize
data class Bar(
    val open: Float,
    val close: Float,
    val low: Float,
    val high: Float,
    val time: Calendar
) : Parcelable