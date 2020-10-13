package com.hcid.app.data.source.remote.helper

import com.google.gson.Gson

object GsonHelper {
    fun <E> toObjectListOf(list: List<Any>,type:Class<E>):List<E>{
        val gson = Gson()
        val jsonArray = gson.toJsonTree(list).asJsonArray
        val articles = arrayListOf<E>().apply {
            jsonArray.forEach {
                this.add(gson.fromJson(it,type))
            }
        }
        return articles
    }
}