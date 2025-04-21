package com.myapp.egghuntlist.data

import android.content.Context

class PreferenceHelper(context: Context){
    private val prefs = context.getSharedPreferences("egg_hunts_list", Context.MODE_PRIVATE)

    fun saveCheckedList(index: Int, isChecked: Boolean){
        prefs.edit().putBoolean("checked_$index", isChecked).apply()
    }

    private fun getCheckedList(index: Int): Boolean{
        return prefs.getBoolean("checked_$index", false)
    }

    fun getAllCheckedList(size: Int): List<Boolean>{
        return List(size){index -> getCheckedList(index)}
    }

    fun resetAll(){
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}