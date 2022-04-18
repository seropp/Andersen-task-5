package com.example.contactstask6.model

import androidx.fragment.app.Fragment

fun Fragment.navigator(): ContactNavigator{
    return requireActivity() as ContactNavigator
}

interface ContactNavigator {

    fun launchDetailsFragment(contact: Contact)

    fun launchContactsFragment(contact: Contact)

}