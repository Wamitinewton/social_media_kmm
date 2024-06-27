package com.example.kmmsocial.android.common.datastore

import androidx.datastore.core.Serializer
import kotlinx.serialization.SerializationException

import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object UserSettingsSerializer : Serializer<UserSettings> {

    /*
    the below default value provides a default value for UserSetting
    this is in case deserialization fails
    */
    override val defaultValue: UserSettings
        get() = UserSettings()


    /*
  readFrom is a suspend function that reads data from the input stream and deserializes it into a UserSettings object.
   */
    override suspend fun readFrom(input: InputStream): UserSettings {
        return try {
            Json.decodeFromString(
                deserializer = UserSettings.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (serialization: SerializationException) {
            defaultValue
        }
    }

    override suspend fun writeTo(t: UserSettings, output: OutputStream) {
        output.write(
            Json.encodeToString(
                serializer = UserSettings.serializer(), value = t
            ).encodeToByteArray()
        )
    }
}