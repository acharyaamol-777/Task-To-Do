package com.example.task_to_do.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.task_to_do.R
import com.example.task_to_do.model.User
import com.example.task_to_do.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.addButton.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {

        val first_name = firstName.text.toString()
        val last_name = lastName.text.toString()
        val age = age.text

        if (inputCheck(first_name,last_name,age)){
            //Create User Object

            val user = User(0, first_name, last_name, Integer.parseInt(age.toString()))

            //Add Data To Dtabase

            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"Successfully added",Toast.LENGTH_LONG).show()

            //Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext()," All fields are required..",Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(first_name:String, last_name:String, age: Editable): Boolean{
        return !(TextUtils.isEmpty(first_name) && TextUtils.isEmpty(last_name) && age.isEmpty())
    }


}