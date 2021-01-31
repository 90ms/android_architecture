package a90ms.easy.default_architecture.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Main")
data class MainData(
    @PrimaryKey
    val id: Long,
    val value: String
) {

}