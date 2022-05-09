package com.example.dictionary.feature_dictionary.data.util

import com.google.gson.Gson
import java.lang.reflect.Type
import javax.inject.Inject

class GsonParser @Inject constructor(private val gson: Gson): JsonParser {

    override fun <T> toJavaObjFromJsonString(json: String, type: Type): T {
       return gson.fromJson(json, type)
    }

    override fun <T> toJsonStringFromJavaObj(obj: T, type: Type): String {
        return gson.toJson(obj, type)
    }

}