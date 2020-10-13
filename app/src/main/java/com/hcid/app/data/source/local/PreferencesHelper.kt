package com.hcid.app.data.source.local

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import com.hcid.app.R
import kotlinx.coroutines.flow.map
import javax.inject.Singleton

@Singleton
class PreferencesHelper(context: Context) {

    private val dataStore: DataStore<Preferences> = context.createDataStore(
        name = context.getString(R.string.app_name)
    )
    private val articleSectionCounter = preferencesKey<String>(context.getString(R.string.articleSectionPreferences))

    fun getArticleSectionTitle() = dataStore.data
        .map { preferences ->
            preferences[articleSectionCounter]?:""
        }

    suspend fun setArticleSectionTitle(title:String) = dataStore.edit { settings ->
        settings[articleSectionCounter] = title
    }

}