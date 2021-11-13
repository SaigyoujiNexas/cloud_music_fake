package com.saigyouji.cloudmusic.persist.db.playList

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.saigyouji.cloudmusic.persist.db.Creator
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

object Convertor{
    @TypeConverter
    fun fromCreatorToJson(creator: Creator) : String
    {
        return Json.encodeToString(creator)
    }
    @TypeConverter
    fun fromJsonToCreator(str: String) : Creator
    {
        return Json.decodeFromString<Creator>(str)
    }
    @TypeConverter
    fun  fromStringListToJson(list: List<String>): String{
        return Json.encodeToString(list)
    }
    @TypeConverter
    fun fromJsonToTList(str: String) : List<String>
    {
        return Json.decodeFromString(str)
    }

}