package com.example.locationreminder

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.locationreminder.dto.ReminderDTO
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PointOfInterest
import kotlinx.coroutines.launch

class SaveViewModel(val app: Application, val dataSource: ReminderDataSource) : ViewModel() {

    val reminderTitle = MutableLiveData<String?>()
    val reminderDescription = MutableLiveData<String?>()
    val reminderLocation = MutableLiveData<String?>()
    val reminderLat = MutableLiveData<Double?>()
    val reminderLng = MutableLiveData<Double?>()
    val selectedPOI = MutableLiveData<PointOfInterest?>()

    fun clearReminder() {
        reminderTitle.value = null
        reminderDescription.value = null
        reminderLocation.value = null
        reminderLat.value = null
        reminderLng.value = null
        selectedPOI.value = null
    }

    fun validateAndSave(reminderData: ReminderData) {
        saveReminder(reminderData)
    }

    fun locationSelected(selectedLocation: LatLng, selectedLocationDescription: String?) {
        reminderLat.value = selectedLocation.latitude
        reminderLng.value = selectedLocation.longitude
        reminderLocation.value = selectedLocationDescription
    }

    fun saveReminder(reminderData: ReminderData) {
        viewModelScope.launch {
            dataSource.saveReminder(
                ReminderDTO(
                    reminderData.title,
                    reminderData.description,
                    reminderData.location,
                    reminderData.latitude,
                    reminderData.longitude,
                    reminderData.id
                )
            )
        }
    }

//    fun validateData(reminderData: ReminderData): Boolean {
//        if (reminderData.title.isNullOrEmpty()) {
//
//        }
//    }
}