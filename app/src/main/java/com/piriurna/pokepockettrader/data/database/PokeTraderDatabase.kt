package com.piriurna.pokepockettrader.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.piriurna.pokepockettrader.data.database.daos.PokemonDao
import com.piriurna.pokepockettrader.data.database.entities.OwnedPokemonEntity
import com.piriurna.pokepockettrader.data.database.entities.PokemonEntity
import com.piriurna.pokepockettrader.data.database.entities.UserEntity

@Database(
    entities = [
        PokemonEntity::class,
        UserEntity::class,
        OwnedPokemonEntity::class
    ],
    version = 6,
    exportSchema = false
)
abstract class PokeTraderDatabase: RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
}