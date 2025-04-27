package com.piriurna.pokepockettrader.ui.root.di

import com.piriurna.pokepockettrader.data.pokemon.apis.PokemonApi
import com.piriurna.pokepockettrader.data.user.LoggedUserImpl
import com.piriurna.pokepockettrader.domain.user.LoggedUser
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
import kotlin.time.Duration.Companion.seconds

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideHttpClient() : OkHttpClient {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)


        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .readTimeout(20.seconds.inWholeSeconds, TimeUnit.SECONDS)
            .connectTimeout(20.seconds.inWholeSeconds, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun providePokemonApi(okHttpClient: OkHttpClient): PokemonApi {
        return Retrofit.Builder()
            .baseUrl("https://api.dotgg.gg/cgfw/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLoggedUser(): LoggedUser {
        return LoggedUserImpl()
    }
}