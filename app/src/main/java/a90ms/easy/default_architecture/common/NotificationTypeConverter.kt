package a90ms.easy.default_architecture.common

import a90ms.easy.default_architecture.data.entity.NotificationType
import androidx.room.TypeConverter

class NotificationTypeConverter {

    @TypeConverter
    fun fromNotificationType(notificationType: NotificationType): String = notificationType.name

    @TypeConverter
    fun toNotificationType(notificationType: String): NotificationType = NotificationType.valueOf(notificationType)

}