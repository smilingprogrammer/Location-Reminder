package com.example.locationreminder

import java.io.Serializable
import java.util.*

data class ReminderData(
    var title: String?,
    var description: String?,
    var location: String?,
    var latitude: Double?,
    var longitude: Double?,
    val id: String = UUID.randomUUID().toString()
): Serializable
