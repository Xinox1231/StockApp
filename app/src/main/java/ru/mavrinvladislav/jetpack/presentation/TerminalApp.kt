package ru.mavrinvladislav.jetpack.presentation

import android.app.Application
import ru.mavrinvladislav.jetpack.di.DaggerApplicationComponent

class TerminalApp: Application() {
    val component by lazy{
        DaggerApplicationComponent.factory().create()
    }
}