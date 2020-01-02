package com.example.sleeptracker

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "sleep")
class Sleep(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val startDate: Long = System.currentTimeMillis(),
    val endDate: String,
    val quantity: Int //0 to 5
)