package com.example.locationreminder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ReminderViewModel(private val dataSource: ReminderDataSource) : ViewModel() {

    val reminderList = MutableLiveData<List<ReminderData>>()

    fun loadReminders() {
        viewModelScope.launch {
            val result = dataSource.getReminders()
        }
    }
}