package ru.mavrinvladislav.jetpack.domain.entity

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("results")
    val barList: List<Bar>
)