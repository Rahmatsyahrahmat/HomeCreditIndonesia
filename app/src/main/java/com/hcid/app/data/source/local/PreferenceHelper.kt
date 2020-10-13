package com.hcid.app.data.source.local

import android.content.Context
import com.hcid.app.R

class PreferenceHelper(private val context: Context) {

    private val preference = context.getSharedPreferences(context.getString(R.string.app_name),Context.MODE_PRIVATE)

    fun getArticleSectionTitle() = preference.getString(context.getString(R.string.articleSectionPreferences),null)

    fun setArticleSectionTitle(title:String) = preference.edit().putString(context.getString(R.string.articleSectionPreferences),title).apply()

}