package com.example.dictionary.feature_dictionary.data.util

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionary.feature_dictionary.domain.model.Meaning
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

@ProvidedTypeConverter
class Converters @Inject constructor(private val jsonParser: JsonParser) {

    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> {
        return jsonParser.toJavaObjFromJsonString(json, object: TypeToken<ArrayList<Meaning>>(){}.type) ?: emptyList<Meaning>()
    }

    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>): String {
        return jsonParser.toJsonStringFromJavaObj(meanings, object: TypeToken<ArrayList<Meaning>>(){}.type) ?: "[]"
    }

}