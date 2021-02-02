package a90ms.easy.default_architecture.data.di

import a90ms.easy.default_architecture.api.BaseApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
object NetworkServiceModule {

    @Singleton
    @Provides
    fun provideNetworkService(@Named(NetworkModule.HOST) retrofitBuilder: Retrofit.Builder):
            BaseApiService = retrofitBuilder.build().create(BaseApiService::class.java)
}
