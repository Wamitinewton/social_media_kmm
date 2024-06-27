package com.example.kmmsocial.android

import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import com.example.kmmsocial.android.common.datastore.UserSettings
import com.example.kmmsocial.android.common.datastore.toAuthResultData
import kotlinx.coroutines.flow.map

class MainActivityViewModel(
    dataStore: DataStore<UserSettings>
): ViewModel() {
    val authState = dataStore.data.map { it.toAuthResultData().token }
}