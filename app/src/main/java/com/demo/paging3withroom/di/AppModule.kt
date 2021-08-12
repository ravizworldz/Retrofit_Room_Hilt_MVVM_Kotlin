package com.demo.paging3withroom.di

import android.app.Application
import android.content.Context
import com.demo.paging3withroom.db.AppDao
import com.demo.paging3withroom.db.AppDatabase
import com.demo.paging3withroom.network.RetroServiceInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun getAppDatabase(context: Application): AppDatabase {
        return AppDatabase.getAppDBInstance(context)
    }

    @Provides
    @Singleton
    fun getAppDao(appDatabase: AppDatabase): AppDao {
        return appDatabase.getAppDao()
    }

    val BASE_URL = "https://api.github.com/search/"

    @Provides
    @Singleton
    fun getRetroServiceInstance(retrofit: Retrofit): RetroServiceInterface {
        return retrofit.create(RetroServiceInterface::class.java)
    }

    @Provides
    @Singleton
    fun getRetroInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}