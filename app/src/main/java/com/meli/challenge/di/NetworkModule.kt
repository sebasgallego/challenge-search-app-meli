package com.meli.challenge.di

import com.meli.challenge.data.network.ProductApiClient
import com.meli.challenge.utils.GlobalsVar
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Módulo de Dagger para proporcionar dependencias.
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    /**
     * Proporciona una instancia de Retrofit.
     *
     * @return Una instancia de Retrofit.
     */
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        // Interceptor para el logging de las solicitudes HTTP.
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        // Cliente HTTP con configuración personalizada.
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .retryOnConnectionFailure(true)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        // Construcción de la instancia de Retrofit.
        return Retrofit.Builder()
            .client(client)
            .baseUrl(GlobalsVar.HOST_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * Proporciona una instancia del cliente de API de productos.
     *
     * @param retrofit La instancia de Retrofit.
     * @return Una instancia de ProductApiClient.
     */
    @Singleton
    @Provides
    fun provideProductApiClient(retrofit: Retrofit): ProductApiClient {
        return retrofit.create(ProductApiClient::class.java)
    }
}
