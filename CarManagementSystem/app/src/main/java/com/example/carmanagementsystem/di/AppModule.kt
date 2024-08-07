package com.example.carmanagementsystem.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.carmanagementsystem.data.local.dao.CarDao
import com.example.carmanagementsystem.data.local.database.AppDatabase
import com.example.carmanagementsystem.data.repository.CarRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase{
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideCarDao(appDatabase: AppDatabase): CarDao {
        return appDatabase.carDao()
    }

    @Singleton
    @Provides
    fun provideCarRepository(carDao: CarDao): CarRepository {
        return CarRepository(carDao)
    }

    @Provides
    @Singleton
    fun provideApplicationContext(app: Application): Context {
        return app.applicationContext
    }

}