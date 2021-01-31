package a90ms.easy.default_architecture.data.entity

import androidx.room.Entity

@Entity(tableName = "Notification", primaryKeys = ["id","notificationType"])
data class Notification(
    val id: Long,
    val notificationType: NotificationType,
    val isOn: Boolean
)