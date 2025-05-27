package ru.mavrinvladislav.jetpack.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.mavrinvladislav.jetpack.presentation.TerminalViewModel

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TerminalViewModel::class)
    fun bindTerminalViewModel(vm: TerminalViewModel): ViewModel
}