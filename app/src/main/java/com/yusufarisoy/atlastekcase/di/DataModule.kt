package com.yusufarisoy.atlastekcase.di

import com.yusufarisoy.atlastekcase.data.repository.CharacterRepository
import com.yusufarisoy.atlastekcase.data.repository.CharacterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository
}
