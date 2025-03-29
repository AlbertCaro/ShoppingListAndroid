package dev.albertocaro.shoppinglist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.albertocaro.shoppinglist.core.RetrofitHelper
import dev.albertocaro.shoppinglist.core.retrofit.TokenInterceptor
import dev.albertocaro.shoppinglist.data.api.services.AuthApiService
import dev.albertocaro.shoppinglist.data.api.services.ShoppingListApiService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideRetrofit(tokenInterceptor: TokenInterceptor): Retrofit =
        RetrofitHelper.getRetrofit(tokenInterceptor)

    @Provides
    @Singleton
    fun provideAuthApiService(retrofit: Retrofit): AuthApiService =
        retrofit.create(AuthApiService::class.java)

    @Provides
    @Singleton
    fun provideShoppingListApiService(retrofit: Retrofit): ShoppingListApiService =
        retrofit.create(ShoppingListApiService::class.java)
}