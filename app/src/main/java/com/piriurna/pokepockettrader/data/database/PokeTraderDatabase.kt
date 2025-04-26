package com.piriurna.pokepockettrader.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.piriurna.pokepockettrader.data.pokemon.daos.PokemonDao
import com.piriurna.pokepockettrader.data.user.daos.UserDao
import com.piriurna.pokepockettrader.data.pokemon.entities.OwnedPokemonEntity
import com.piriurna.pokepockettrader.data.pokemon.entities.PokemonEntity
import com.piriurna.pokepockettrader.data.user.entities.UserEntity

@Database(
    entities = [
        PokemonEntity::class,
        UserEntity::class,
        OwnedPokemonEntity::class,
    ],
    version = 6,
    exportSchema = false
)
abstract class PokeTraderDatabase: RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

    abstract fun userDao(): UserDao
}