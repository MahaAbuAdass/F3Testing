package com.example.f3testing.di

import com.example.f3testing.data.remote.F3Api
import com.example.f3testing.data.remote.F3Api.Companion.BASE_URL
import com.example.f3testing.data.remote.repository.F3RepositoryImpl
import com.example.f3testing.domain.repository.F3Repository
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

    @Provides
    @Singleton
    fun getServices(): F3Api {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(F3Api::class.java)
    }

    @Provides
    @Singleton
    fun getAllServices(f3Api: F3Api): F3Repository {
        return F3RepositoryImpl(getAllServicesApi = f3Api)
    }

}