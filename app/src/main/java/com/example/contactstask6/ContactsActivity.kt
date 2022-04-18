package com.example.contactstask6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.example.contactstask6.model.Contact
import com.example.contactstask6.model.ContactNavigator

class ContactsActivity : AppCompatActivity(), ContactNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, ContactsList())
            .commit()
    }

    override fun launchDetailsFragment(
        contact: Contact
    ) {
        Log.e("TAg", "SECOND 1")

        supportFragmentManager
            .beginTransaction()
            .addToBackStack("STACK")
            .replace(R.id.container, ContactInfoFragment.newInstance(contact = contact))
            .commit()
    }

    override fun launchContactsFragment(
        contact: Contact
    ) {
        supportFragmentManager
            .popBackStack("STACK", FragmentManager.POP_BACK_STACK_INCLUSIVE)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ContactsList.newInstance(contact = contact))
            .commit()
    }
}