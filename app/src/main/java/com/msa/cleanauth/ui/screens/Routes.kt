package com.msa.cleanauth.ui.screens

import android.content.SharedPreferences
import com.msa.compose.routing.RouteHandlerScope

@Suppress("NOTHING_TO_INLINE")
inline fun RouteHandlerScope.globalRoutes() {


}
//
//inline fun SharedPreferences.edit(
//     commit: Boolean = false ,
//    action: SharedPreferences.Editor.() -> Unit
//){
//    val editor : SharedPreferences.Editor = edit()
//    action(editor)
//    if(commit){
//        editor.commit();
//    }else {
//        editor.apply();
//    }
//
//}
//
//class PreferenceManager(private val preferences: SharedPreferences){
//
//    fun saveToken(token:String){
//
//        preferences.edit{
//            putString("keyToken",token)
//        }
//
//    }
//}