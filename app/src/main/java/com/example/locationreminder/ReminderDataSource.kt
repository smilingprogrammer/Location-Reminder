package com.example.locationreminder

import com.example.locationreminder.dto.ReminderDTO
import com.example.locationreminder.utils.Result

interface ReminderDataSource {
    suspend fun getReminders(): Result<List<ReminderDTO>>
    suspend fun saveReminder(reminder: ReminderDTO)
    suspend fun getReminder(id: String): Result<ReminderDTO>
    suspend fun deleteAll()
}