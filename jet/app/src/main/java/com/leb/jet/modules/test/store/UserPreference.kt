package com.leb.jet.modules.test.store

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private const val USER_PREFERENCE_NAME = "test_user_preferences";

/**
 * 1、创建Preference DataStore .
 * 在文件的顶层示例化一次
 */
public  val Context.userDataStore by preferencesDataStore(
    name = USER_PREFERENCE_NAME,
//    produceMigrations = { context ->
//        //migrating SharedPreference to DataStore
//        listOf(SharedPreferencesMigration(context, USER_PREFERENCE_NAME))
//    }
)


/**
 * DataStore 的简单示例，可以考虑怎么封装
 */
class UserPreference(val store:DataStore<Preferences>) {

    companion object {
        val TAG  ="user_preference";
//        public  val Context.dataStoreInl by preferencesDataStore(
//            name = USER_PREFERENCE_NAME,
//        )
    }

    private object PreferenceKeys {
        val USER_NAME = stringPreferencesKey("user_name");
        val USER_ID = intPreferencesKey("user_id");
        //是否付费
        val USER_PAY = booleanPreferencesKey("user_pay");
    }

    suspend fun setUserName(userName:String) {
        store.edit { preferences ->
            preferences[PreferenceKeys.USER_NAME] = userName;
        }
    }

     fun getUserName():Flow<String> =
        store.data.catch { exception ->
            if(exception is IOException) {
                Log.e(TAG,"Error reading preference",exception);
                emit(emptyPreferences());
            } else {
                throw  exception;
            }
        }.map { preferences -> preferences[PreferenceKeys.USER_NAME] ?: ""
        }


}