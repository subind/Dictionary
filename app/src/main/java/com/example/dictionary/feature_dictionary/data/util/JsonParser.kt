package com.example.dictionary.feature_dictionary.data.util

import java.lang.reflect.Type

interface JsonParser {

    fun <T> toJavaObjFromJsonString(json: String, type: Type): T

    fun <T> toJsonStringFromJavaObj(obj: T, type: Type): String

}