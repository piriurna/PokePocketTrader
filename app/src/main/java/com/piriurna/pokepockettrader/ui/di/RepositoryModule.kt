package com.piriurna.pokepockettrader.ui.di

import android.app.Application
import com.piriurna.pokepockettrader.data.apis.PokemonApi
import com.piriurna.pokepockettrader.data.database.PokeTraderDatabase
import com.piriurna.pokepockettrader.data.database.daos.PokemonDao
import com.piriurna.pokepockettrader.data.repositories.PokemonRepositoryImpl
import com.piriurna.pokepockettrader.domain.repositories.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideAppDataStoreRepository(pokemonApi: PokemonApi, database: PokeTraderDatabase) : PokemonRepository {
        return PokemonRepositoryImpl(pokemonApi, database.pokemonDao())
    }
}