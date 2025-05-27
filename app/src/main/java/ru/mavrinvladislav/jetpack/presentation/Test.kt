package ru.mavrinvladislav.jetpack.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Test() {
    var testData by rememberSaveable(
        saver = TestData.saver
    ) {
        mutableStateOf(TestData(0, "Number"))
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                testData = testData.copy(number = testData.number + 1)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = "text: $testData")
    }
}

data class TestData(val number: Int, val text: String) {

    companion object {
        val saver: Saver<MutableState<TestData>, Any> = listSaver(
            save = {
                val testData = it.value
                listOf(testData.number, testData.text)
            },
            restore = {
                mutableStateOf(TestData(it[0] as Int, it[1] as String))
            }
        )
    }
}