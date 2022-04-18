package com.example.contactstask6.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    val firstName: String?,
    val lastName: String?,
    val phoneNumber: String?,
    val id: Int
) : Parcelable
