package com.example.sleeptracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SleepViewModel(application: Application):AndroidViewModel(application) {

    private val sleepRespository:SleepRespository

    val sleepList : LiveData<List<Sleep>>

    init{
        val sleepDao = SleepDatabase.getDatabase(application).sleepDao()
        sleepRespository= SleepRespository(sleepDao)
        sleepList = sleepRespository.sleepList
    }

    //execute a coroutine
    fun insertSleep(sleep:Sleep) = viewModelScope.launch {
        sleepRespository.insertSleep(sleep)
    }
}