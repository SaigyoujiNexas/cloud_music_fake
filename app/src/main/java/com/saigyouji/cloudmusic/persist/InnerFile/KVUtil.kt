package com.saigyouji.cloudmusic.persist.InnerFile

import android.content.Context
import com.google.gson.Gson
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object KVUtil {
    fun writeInt(context: Context?, fileName: String, key : String, `val`: Int)
    {
        val sharedPref = context?.getSharedPreferences(fileName, Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()){
            putInt(key, `val`)
        }
    }
    fun readInt(context: Context?, fileName: String, key: String) : Int?
    {
        val sharedPref = context?.getSharedPreferences(fileName,Context.MODE_PRIVATE) ?: return null
        return sharedPref.getInt(key, 0)
    }
    fun writeString(context: Context?, fileName: String, key: String, value: String)
    {
        val sharedPref = context?.getSharedPreferences(fileName, Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()){
            putString(key, value)
        }
    }
    fun readString(context: Context?, fileName: String, key: String) : String?
    {
        val sharedPref = context?.getSharedPreferences(fileName, Context.MODE_PRIVATE) ?: return null
        return sharedPref.getString(key, "")
    }
    fun writeFloat(context: Context?, fileName: String, key: String, value: Float)
    {
        val sharedPref = context?.getSharedPreferences(fileName, Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit())
        {
            putFloat(key, value)
        }
    }
    fun readFloat(context: Context?, fileName: String, key: String) : Float?
    {
        val sharedPref = context?.getSharedPreferences(fileName, Context.MODE_PRIVATE) ?: return null
        return sharedPref.getFloat(key, 0f)
    }

    inline fun <reified T> writeObject(context: Context?, fileName: String, key: String, obj: T)
    {
        val sharedPref = context?.getSharedPreferences(fileName, Context.MODE_PRIVATE) ?: return
        val saved = Json.encodeToString(obj)
        with(sharedPref.edit()) {
            putString(key, saved).commit()
        }
    }
    inline fun <reified T> readObject(context: Context?, fileName: String, key: String, cls: Class<T>): T?
    {
        val sharedPref = context?.getSharedPreferences(fileName, Context.MODE_PRIVATE) ?:return null
        val str = sharedPref.getString(key, "")
        return Json.decodeFromString(str!!)
    }
}