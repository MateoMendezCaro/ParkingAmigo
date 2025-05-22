package com.app.parkingamigo.data.remote.di

import com.app.parkingamigo.data.remote.api.LoginApi
import com.app.parkingamigo.data.remote.api.TarifaApi
import com.app.parkingamigo.data.remote.api.MovimientoApi
import com.app.parkingamigo.data.remote.repository.LoginRepositoryImpl
import com.app.parkingamigo.data.remote.repository.MovimientoRepositoryImpl
import com.app.parkingamigo.data.remote.repository.TarifaRepositoryImpl
import com.app.parkingamigo.domain.repository.LoginRepository
import com.app.parkingamigo.domain.repository.MovimientoRepository
import com.app.parkingamigo.domain.repository.TarifaRepository
import com.app.parkingamigo.domain.usecases.GetMovimientosUseCase
import com.app.parkingamigo.domain.usecases.GetTarifasUseCase
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
            .baseUrl("https://us-central1-parkingamigo-c649c.cloudfunctions.net/")
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

    @Provides @Singleton
    fun provideTarifaApi(retrofit: Retrofit): TarifaApi =
        retrofit.create(TarifaApi::class.java)

    @Provides @Singleton
    fun provideTarifaRepository(api: TarifaApi): TarifaRepository =
        TarifaRepositoryImpl(api)

    @Provides @Singleton
    fun provideGetTarifasUseCase(repo: TarifaRepository): GetTarifasUseCase =
        GetTarifasUseCase(repo)

    @Provides @Singleton
    fun provideMovimientoApi(retrofit: Retrofit): MovimientoApi =
        retrofit.create(MovimientoApi::class.java)

    @Provides @Singleton
    fun provideMovimientoRepository(api: MovimientoApi): MovimientoRepository =
        MovimientoRepositoryImpl(api)

    @Provides @Singleton
    fun provideGetMovimientosUseCase(repo: MovimientoRepository): GetMovimientosUseCase =
        GetMovimientosUseCase(repo)
}
