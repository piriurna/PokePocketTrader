package com.piriurna.pokepockettrader.di

import com.piriurna.pokepockettrader.data.database.PokeTraderDatabase
import com.piriurna.pokepockettrader.data.pokemon.apis.PokemonApi
import com.piriurna.pokepockettrader.data.pokemon.repositories.PokemonRepositoryImpl
import com.piriurna.pokepockettrader.data.user.repositories.UserRepositoryImpl
import com.piriurna.pokepockettrader.domain.pokemon.repositories.PokemonRepository
import com.piriurna.pokepockettrader.domain.user.repositories.UserRepository
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
    fun providePokemonRepository(pokemonApi: PokemonApi, database: PokeTraderDatabase) : PokemonRepository {
        return PokemonRepositoryImpl(pokemonApi, database.pokemonDao())
    }

    @Provides
    @Singleton
    fun provideUserRepository(database: PokeTraderDatabase) : UserRepository {
        return UserRepositoryImpl(database.userDao())
    }
}