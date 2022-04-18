package com.example.contactstask6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contactstask6.databinding.FragmentContactInfoBinding
import com.example.contactstask6.model.Contact
import com.example.contactstask6.model.navigator

private const val KEY_CONTACT = "CONTACT"

class ContactInfoFragment : Fragment() {

    private lateinit var binding: FragmentContactInfoBinding
    private lateinit var contact: Contact

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactInfoBinding.inflate(inflater, container, false)

        arguments?.let {
            contact = it.getParcelable(KEY_CONTACT)!!
        }

        binding.contactFirstName.text = contact.firstName
        binding.contactLastName.text = contact.lastName
        binding.contactPhoneNumber.text = contact.phoneNumber

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            navigator().launchContactsFragment(
                Contact(
                    firstName = binding.etFirstNameContact.text.toString(),
                    lastName = binding.etLastNameContact.text.toString(),
                    phoneNumber = binding.etPhoneNumberContact.text.toString(),
                    id = contact.id
                )
            )
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(contact: Contact) =
            ContactInfoFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_CONTACT, contact)
                }
            }
    }
}