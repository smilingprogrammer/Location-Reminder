package com.example.locationreminder

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.locationreminder.dto.ReminderDTO
import com.example.locationreminder.utils.Result
import kotlinx.coroutines.launch

class ReminderViewModel(private val dataSource: ReminderDataSource) : ViewModel() {

    val reminderList = MutableLiveData<List<ReminderData>>()

    fun loadReminders() {
        viewModelScope.launch {
            val result = dataSource.getReminders()
            when (result) {
                is Result.Success<*> -> {
                    val dataList = ArrayList<ReminderData>()
                    dataList.addAll((result.data as List<ReminderDTO>).map {
                        ReminderData(
                            it.title,
                            it.description,
                            it.location,
                            it.latitude,
                            it.longitude,
                            it.id
                        )
                    })
                    reminderList.value = dataList
                }
                is Result.Error -> Log.d("ReminderViewModel", "${result.message}")
            }
            invalidateShowNoData()
        }
    }

    private fun invalidateShowNoData() {
        reminderList.value == null || reminderList.value!!.isEmpty()
    }
}