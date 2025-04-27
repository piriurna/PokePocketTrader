package com.piriurna.pokepockettrader.ui.root.di

import android.content.Context
import androidx.room.Room
import com.piriurna.pokepockettrader.data.database.PokeTraderDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        PokeTraderDatabase::class.java,
        "pokepockettrader_db"
    ).fallbackToDestructiveMigration(false).build()
}