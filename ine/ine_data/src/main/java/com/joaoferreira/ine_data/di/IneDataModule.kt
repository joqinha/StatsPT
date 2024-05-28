package com.joaoferreira.ine_data.di

import android.app.Application
import androidx.room.Room
import com.joaoferreira.ine_data.local.IneDatabase
import com.joaoferreira.ine_data.remote.IneApi
import com.joaoferreira.ine_data.remote.dto.IndicadorIneDto
import com.joaoferreira.ine_data.repository.IneRepositoryImpl
import com.joaoferreira.ine_domain.repository.IneRepository
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class IneDataModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @Singleton
    fun provideIndicadorIneDtoAdapter(moshi: Moshi): JsonAdapter<List<IndicadorIneDto>> {
        val type = Types.newParameterizedType(List::class.java, IndicadorIneDto::class.java)
        return moshi.adapter(type)
    }

    @Provides
    @Singleton
    fun provideIneApi(client: OkHttpClient, moshi: Moshi): IneApi {
        return Retrofit.Builder()
            .baseUrl(IneApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()
            .create(IneApi::class.java)
    }

    @Provides
    @Singleton
    fun provideIneDatabase(app: Application): IneDatabase {
        return Room.databaseBuilder(
            app,
            IneDatabase::class.java,
            "ine_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideIneRepository(
        api: IneApi,
        db: IneDatabase
    ): IneRepository {
        return IneRepositoryImpl(
            api = api,
            dao = db.dao
        )
    }
}