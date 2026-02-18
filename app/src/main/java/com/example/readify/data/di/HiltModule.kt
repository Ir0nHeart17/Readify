package com.example.readify.data.di

import com.example.readify.data.RepoImpl.AllBookRepoImpl
import com.example.readify.domain.repo.AllBookRepo
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule{

    @Provides
    @Singleton
    fun provideRealTimeDatabase() : FirebaseDatabase {
        return FirebaseDatabase.getInstance() //firebase instance for realtime database and we dont have to create other instances
    }

    @Provides
    @Singleton
    fun provieFirebaseStorage(): FirebaseStorage {
        return FirebaseStorage.getInstance() //firebase instance for realtime database
    }

    @Provides
    @Singleton
    fun provideAllBookRepo(firebaseDatabase: FirebaseDatabase) : AllBookRepo{
        return AllBookRepoImpl(firebaseDatabase)
    }
}


