package com.example.contactstask6

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contactstask6.databinding.FragmentContactsListBinding
import com.example.contactstask6.model.Contact
import com.example.contactstask6.model.navigator

private const val KEY_CONTACT = "CONTACT"

class ContactsList : Fragment() {

    private lateinit var binding: FragmentContactsListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactsListBinding.inflate(inflater, container, false)



        arguments?.let {
            let {
                when (requireArguments().getParcelable<Contact>(KEY_CONTACT)?.id) {
                    1 -> {
                        binding.tvName1.text = requireArguments().getParcelable<Contact>(KEY_CONTACT)?.firstName
                        binding.tvSurname1.text = requireArguments().getParcelable<Contact>(KEY_CONTACT)?.lastName
                        binding.tvPhoneNumber1.text = requireArguments().getParcelable<Contact>(KEY_CONTACT)?.phoneNumber
                    }
                    2 -> {
                        binding.tvName2.text = requireArguments().getParcelable<Contact>(KEY_CONTACT)?.firstName
                        binding.tvSurname2.text = requireArguments().getParcelable<Contact>(KEY_CONTACT)?.lastName
                        binding.tvPhoneNumber2.text = requireArguments().getParcelable<Contact>(KEY_CONTACT)?.phoneNumber
                    }
                    3 -> {
                        binding.tvName3.text = requireArguments().getParcelable<Contact>(KEY_CONTACT)?.firstName
                        binding.tvSurname3.text = requireArguments().getParcelable<Contact>(KEY_CONTACT)?.lastName
                        binding.tvPhoneNumber3.text = requireArguments().getParcelable<Contact>(KEY_CONTACT)?.phoneNumber
                    }
                }
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.firstContact.setOnClickListener {
            navigator().launchDetailsFragment(
                Contact(
                    firstName = binding.tvName1.text.toString(),
                    lastName = binding.tvSurname1.text.toString(),
                    phoneNumber = binding.tvPhoneNumber1.text.toString(),
                    id = 1
                )
            )
        }

        binding.secondContact.setOnClickListener {
            navigator().launchDetailsFragment(

                Contact(
                    firstName = binding.tvName2.text.toString(),
                    lastName = binding.tvSurname2.text.toString(),
                    phoneNumber = binding.tvPhoneNumber2.text.toString(),
                    id = 2
                )
            )
        }

        binding.thirdContact.setOnClickListener {
            navigator().launchDetailsFragment(
                Contact(
                    firstName = binding.tvName3.text.toString(),
                    lastName = binding.tvSurname3.text.toString(),
                    phoneNumber = binding.tvPhoneNumber3.text.toString(),
                    id = 3
                )
            )
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(contact: Contact) =
            ContactsList().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_CONTACT, contact)
                }
            }
    }
}