package a90ms.easy.default_architecture.api

import io.reactivex.rxjava3.core.Completable
import retrofit2.http.POST
import retrofit2.http.Path

interface BaseApiService {

    @POST("$V1_PATH/user/{$PATH_USER_ID}")
    fun getData(@Path(PATH_USER_ID) userId: Long): Completable

    companion object {
        const val V1_PATH = "v1"
        const val PATH_USER_ID = "userId"
    }
}
