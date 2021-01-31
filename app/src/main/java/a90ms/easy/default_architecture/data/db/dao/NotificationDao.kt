package a90ms.easy.default_architecture.data.db.dao

import a90ms.easy.default_architecture.data.entity.Notification
import a90ms.easy.default_architecture.data.entity.NotificationType
import androidx.room.Query
import io.reactivex.rxjava3.core.Maybe

interface NotificationDao : BaseDao<Notification> {
    @Query("SELECT * FROM Notification")
    fun getNotification(): Maybe<Notification>

    @Query("SELECT * FROM Notification WHERE id = :id AND notificationType = :notificationType")
    fun getNotificationByIdWithType(id: Long, notificationType: NotificationType): Maybe<Notification>
}