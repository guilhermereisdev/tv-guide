package com.guilhermereisdev.tvguide.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.guilhermereisdev.tvguide.data.model.artist.KnownFor

class Converters {
    @TypeConverter
    fun fromListInt(list: List<Int>): String {
        return list.joinToString(",")
    }

    @TypeConverter
    fun toListInt(data: String): List<Int> {
        return listOf(*data.split(",").map { it.toInt() }.toTypedArray())
    }

    @TypeConverter
    fun fromListString(listOfString: List<String?>?): String {
        return Gson().toJson(listOfString)
    }

    @TypeConverter
    fun toListString(data: String?): List<String> {
        return Gson().fromJson(data, object : TypeToken<List<String?>?>() {}.type)
    }

    @TypeConverter
    fun fromListKnownFor(listOfKnownFor: List<KnownFor?>?): String {
        return Gson().toJson(listOfKnownFor)
    }

    @TypeConverter
    fun toListKnownFor(data: String?): List<KnownFor> {
        return Gson().fromJson(data, object : TypeToken<List<KnownFor?>?>() {}.type)
    }
}
