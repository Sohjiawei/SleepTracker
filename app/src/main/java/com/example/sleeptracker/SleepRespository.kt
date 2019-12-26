package com.example.sleeptracker

import androidx.lifecycle.LiveData

class SleepRespository(private val sleepDao: SleepDao){
    private val sleepList : LiveData<List<Sleep>> = SleepDao.getSleep()
    
    suspend fun insertSleep(sleep: Sleep){
        sleepDao.insertSleep((sleep))
    }
}