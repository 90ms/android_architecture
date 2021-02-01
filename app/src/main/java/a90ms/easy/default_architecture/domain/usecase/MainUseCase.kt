package a90ms.easy.default_architecture.domain.usecase

import a90ms.easy.default_architecture.domain.repository.MainRepository
import io.reactivex.rxjava3.core.Completable

class MainUseCase(private val mainRepository: MainRepository) {
    fun getMainData(): Completable = mainRepository.getMainData()
}
