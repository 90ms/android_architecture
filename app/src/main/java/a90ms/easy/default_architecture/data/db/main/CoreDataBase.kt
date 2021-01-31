package a90ms.easy.default_architecture.data.db.main

import a90ms.easy.default_architecture.data.db.dao.MainDao
import a90ms.easy.default_architecture.data.db.dao.NotificationDao
import a90ms.easy.default_architecture.data.entity.MainData
import a90ms.easy.default_architecture.data.entity.Notification
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        MainData::class,
        Notification::class
    ],
    version = 1,
    exportSchema = false
)
//@TypeConverter(NotificationTypeConverter::class)
abstract class CoreDataBase: RoomDatabase() {
    abstract fun mainDao(): MainDao
    abstract fun notificationDao(): NotificationDao

    companion object {
        const val DB_NAME = "core.db"
    }
}