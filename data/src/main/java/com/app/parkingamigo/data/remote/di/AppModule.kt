package com.app.parkingamigo.data.remote.di

import com.app.parkingamigo.data.remote.api.LoginApi
import com.app.parkingamigo.data.remote.repository.LoginRepositoryImpl
import com.app.parkingamigo.domain.repository.LoginRepository
import com.app.parkingamigo.domain.usecases.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://192.168.68.108/parkingamigo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides @Singleton
    fun provideLoginApi(retrofit: Retrofit): LoginApi =
        retrofit.create(LoginApi::class.java)

    @Provides @Singleton
    fun provideLoginRepository(api: LoginApi): LoginRepository =
        LoginRepositoryImpl(api)

    @Provides @Singleton
    fun provideLoginUseCase(repo: LoginRepository): LoginUseCase =
        LoginUseCase(repo)
}
