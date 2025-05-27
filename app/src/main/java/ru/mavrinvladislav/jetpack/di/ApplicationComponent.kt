package ru.mavrinvladislav.jetpack.di

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import dagger.Component
import ru.mavrinvladislav.jetpack.presentation.TerminalApp
import ru.mavrinvladislav.jetpack.presentation.ViewModelFactory

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        RemoteModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun getViewModelFactory(): ViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(
        ): ApplicationComponent
    }
}

@Composable
fun getApplicationComponent(): ApplicationComponent {
    val context = LocalContext.current
    Log.d("RECOMPOSITION_TAG", "getApplicationComponent")
    return remember(context) { (context.applicationContext as TerminalApp).component }
}