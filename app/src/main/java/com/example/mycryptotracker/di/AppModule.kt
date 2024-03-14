package com.example.mycryptotracker.di

import com.example.mycryptotracker.common.Constants
import com.example.mycryptotracker.data.remote.ApiInterceptor
import com.example.mycryptotracker.data.remote.CryptoCurrencyApi
import com.example.mycryptotracker.data.repository.CryptoRepositoryImpl
import com.example.mycryptotracker.domain.repository.CryptoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCryptoCurrencyApi(): CryptoCurrencyApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(OkHttpClient.Builder().apply {
                addInterceptor(ApiInterceptor())
            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoCurrencyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CryptoCurrencyApi): CryptoRepository {
        return CryptoRepositoryImpl(api)
    }
}