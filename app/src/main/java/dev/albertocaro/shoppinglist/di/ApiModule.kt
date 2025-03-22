package dev.albertocaro.shoppinglist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.albertocaro.shoppinglist.core.RetrofitHelper
import dev.albertocaro.shoppinglist.data.api.services.AuthApiService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = RetrofitHelper.getRetrofit()

    @Provides
    @Singleton
    fun provideAuthApiService(retrofit: Retrofit): AuthApiService = retrofit.create(AuthApiService::class.java)
}