package a90ms.easy.default_architecture.data.di

import dagger.Module
import dagger.hilt.InstallIn

@Module

object NetworkModule {
    const val HOST = "https://api.unsplash.com/"
}
