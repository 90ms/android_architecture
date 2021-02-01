package a90ms.easy.default_architecture.domain.repository

import a90ms.easy.default_architecture.api.BaseApiService
import io.reactivex.rxjava3.core.Completable

class MainRepositoryImpl(private val baseApiService: BaseApiService): MainRepository {
    override fun getMainData(): Completable = baseApiService.getData(123L)
}
