package com.app.parkingamigo.data.di

import android.content.Context
import androidx.room.Room
import com.app.parkingamigo.data.local.AppDatabase
import com.app.parkingamigo.data.local.UserDao
import com.app.parkingamigo.data.repository.UserRepositoryImpl
import com.app.parkingamigo.domain.useCases.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "parkingamigo"
        ).build()
    }

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepositoryImpl {
        return UserRepositoryImpl(userDao)
    }

    @Provides
    fun provideLoginUseCase(userRepositoryImpl: UserRepositoryImpl): LoginUseCase {
        return LoginUseCase(userRepositoryImpl)
    }
}