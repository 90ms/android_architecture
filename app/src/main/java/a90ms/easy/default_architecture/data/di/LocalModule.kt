package a90ms.easy.default_architecture.data.di

import a90ms.easy.default_architecture.data.db.dao.MainDao
import a90ms.easy.default_architecture.data.db.dao.NotificationDao
import a90ms.easy.default_architecture.data.db.dataStore.MainDataStore
import a90ms.easy.default_architecture.data.db.main.CoreDataBase
import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.createDataStore
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.prefs.Preferences
import javax.inject.Singleton

@Module
@InstallIn()
object LocalModule {

    @Singleton
    @Provides
    fun provideSharePreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("settings_pref", Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideSettingsDataStore(@ApplicationContext context: Context) =
        context.createDataStore("settings_pref")

    @Singleton
    @Provides
    fun provideMainDataStore(
        dataStore: DataStore<Preferences>,
        sharedPreferences: SharedPreferences
    ): MainDataStore = MainDataStore(
        dataStore = dataStore,
        sharedPreferences = sharedPreferences
    )

    @Singleton
    @Provides
    fun provideCoreDataBase(@ApplicationContext context: Context): CoreDataBase =
        Room.databaseBuilder(context, CoreDataBase::class.java, CoreDataBase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideCategoryDao(coreDataBase: CoreDataBase): MainDao =
        coreDataBase.mainDao()

    @Provides
    fun provideNotificationDao(coreDataBase: CoreDataBase): NotificationDao =
        coreDataBase.notificationDao()
}