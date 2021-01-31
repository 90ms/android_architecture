package a90ms.easy.default_architecture.data.db.dataStore

import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import java.util.prefs.Preferences

class MainDataStore(
    private val dataStore: DataStore<Preferences>,
    private val sharedPreferences: SharedPreferences
) {

    companion object {
        private const val KEY_DEFAULT = "main_default"
    }

    fun setBooleanData(value: Boolean) {
        sharedPreferences.edit().putBoolean(KEY_DEFAULT, value).apply()
    }

    fun getDefaultData(): Boolean = sharedPreferences.getBoolean(KEY_DEFAULT,true)

    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }
}