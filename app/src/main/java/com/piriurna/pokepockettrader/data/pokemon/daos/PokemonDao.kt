package com.piriurna.pokepockettrader.data.pokemon.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.piriurna.pokepockettrader.data.pokemon.entities.PokemonEntity
import com.piriurna.pokepockettrader.data.pokemon.entities.UserOwnedPokemon
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon")
    fun getAll(): List<PokemonEntity>

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertPokemon(pokemonList: List<PokemonEntity>): List<Long>

    @Query("""
        SELECT p.*, 
        CASE WHEN op.pokemonId IS NOT NULL THEN 1 ELSE 0 END as isOwned
        FROM Pokemon p
        LEFT JOIN OwnedPokemon op ON p.id = op.pokemonId AND op.ownerId = :currentUserId
    """)
    fun getAllPokemonWithOwnership(currentUserId: String): Flow<List<UserOwnedPokemon>>

    @Query(
        """
            INSERT INTO ownedPokemon (pokemonId, ownerId) VALUES (:pokemonId, :nickname)
        """
    )
    fun addPokemonToUser(pokemonId: String, nickname: String)

    @Query(
        """
            DELETE FROM ownedPokemon
            WHERE id IN (
               SELECT id FROM ownedPokemon
               WHERE pokemonId =:pokemonId AND ownerId =:nickname
               LIMIT 1
            )
        """
    )
    fun removePokemonFromUser(pokemonId: String, nickname: String)
}