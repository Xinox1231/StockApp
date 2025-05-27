package ru.mavrinvladislav.jetpack.di

import dagger.Binds
import dagger.Module
import ru.mavrinvladislav.jetpack.data.repository.BarRepositoryImpl
import ru.mavrinvladislav.jetpack.domain.repository.BarRepository

@Module
interface DataModule {

    @Binds
    fun bindBarRepository(impl: BarRepositoryImpl): BarRepository
}