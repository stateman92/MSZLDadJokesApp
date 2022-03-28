package hu.bme.aut.dadjokes.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import hu.bme.aut.dadjokes.network.NetworkService
import hu.bme.aut.dadjokes.persistence.JokeDao
import hu.bme.aut.dadjokes.ui.main.MainRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideMainRepository(
        disneyService: NetworkService,
        jokeDao: JokeDao
    ) = MainRepository(disneyService, jokeDao)
}