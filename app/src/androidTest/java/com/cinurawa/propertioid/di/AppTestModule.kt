package com.cinurawa.propertioid.di

import android.app.Application
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import dagger.Module
import dagger.Provides
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [ViewModelComponent::class],
    replaces = [AppModule::class]
)
class AppTestModule {

    @Provides
    @ViewModelScoped
    fun provideVideoPlayer(app: Application): Player = ExoPlayer.Builder(app)
        .build()
}