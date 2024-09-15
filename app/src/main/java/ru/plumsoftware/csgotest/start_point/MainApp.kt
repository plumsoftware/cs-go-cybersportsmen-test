package ru.plumsoftware.csgotest.start_point

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.plumsoftware.csgotest.presentation.di.mainModules
import ru.plumsoftware.csgotest.presentation.di.viewModelModule

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(mainModules, viewModelModule)
            androidContext(this@MainApp)
        }
    }
}