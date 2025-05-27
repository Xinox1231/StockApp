package ru.mavrinvladislav.jetpack.data.remote.model

import android.icu.util.Calendar
import androidx.compose.runtime.Immutable
import com.google.gson.annotations.SerializedName
import java.util.Date

@Immutable
data class BarDto(

    @SerializedName("o")
    val open: Float,
    @SerializedName("c")
    val close: Float,
    @SerializedName("l")
    val low: Float,
    @SerializedName("h")
    val high: Float,
    @SerializedName("t")
    val time: Long
) {

}