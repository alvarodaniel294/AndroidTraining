package com.bootcamp.motion_data

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferences(context: Context) {

    private val applicationContext = context.applicationContext
    private val dataStore: DataStore<Preferences>

    init {
        dataStore = applicationContext.createDataStore(name = "DataStorePreferences")
    }

    val name: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_NAME]
        }

    suspend fun saveName(name:String){
        dataStore.edit { preferences ->
            preferences[KEY_NAME] = name
        }
    }



    companion object {
        val KEY_NAME = preferencesKey<String>("key_name")
    }

}