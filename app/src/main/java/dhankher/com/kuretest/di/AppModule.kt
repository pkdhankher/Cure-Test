package dhankher.com.kuretest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dhankher.com.kuretest.network.RemoteDataSource
import dhankher.com.kuretest.network.SendbirdPlatformApis

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideHomeScreenAPIs(remoteDataSource: RemoteDataSource):SendbirdPlatformApis{
        return remoteDataSource.buildApi(SendbirdPlatformApis::class.java)
    }
}