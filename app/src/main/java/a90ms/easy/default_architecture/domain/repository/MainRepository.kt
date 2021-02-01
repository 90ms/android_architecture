package a90ms.easy.default_architecture.domain.repository

import io.reactivex.rxjava3.core.Completable

interface MainRepository {
    fun getMainData() : Completable
}
