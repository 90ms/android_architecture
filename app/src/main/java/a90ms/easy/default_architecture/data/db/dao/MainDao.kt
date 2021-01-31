package a90ms.easy.default_architecture.data.db.dao

import a90ms.easy.default_architecture.data.entity.MainData
import androidx.room.Dao
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface MainDao : BaseDao<MainData> {

    @Query("SELECT * FROM Main")
    fun getCategoryList(): Single<List<MainData>>

    @Query("DELETE FROM Main")
    fun deleteAll(): Completable
}