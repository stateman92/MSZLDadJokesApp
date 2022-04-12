package hu.bme.aut.dadjokes.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.dadjokes.R
import hu.bme.aut.dadjokes.persistence.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun provideAppDatabase(application: Application) = Room
        .databaseBuilder(
            application,
            AppDatabase::class.java,
            application.getString(R.string.database)
        )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideJokeDao(appDatabase: AppDatabase) = appDatabase.jokeDao()
}