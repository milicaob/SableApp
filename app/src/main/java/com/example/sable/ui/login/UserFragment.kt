package com.example.sable.ui.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.sable.databinding.FragmentUserBinding

import com.example.sable.R
import com.example.sable.SELECT_IMAGE_REQUEST_CODE
import com.google.android.material.floatingactionbutton.FloatingActionButton
var PROMENJENA = 0
var PROMENJENA_IME1 = 0
var PROMENJENA_IME2 = 0
var PROMENJENA_RES = 0

class UserFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private var _binding: FragmentUserBinding? = null

<<<<<<< HEAD
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
=======
>>>>>>> 6e9cd1e (Gotovo! Male izmene)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val updateButton = view.findViewById<FloatingActionButton>(R.id.floating_pic)

        val firstNameEdit = view.findViewById<EditText>(R.id.editTextFirstName)
        val secondNameEdit = view.findViewById<EditText>(R.id.editTextSecondName)
        val resEdit = view.findViewById<EditText>(R.id.editTextRestaurant)

        val sharedPref = activity?.getSharedPreferences("my_pref",Context.MODE_PRIVATE)
        val firstName = sharedPref?.getString("first_name", "")
        val secondName = sharedPref?.getString("second_name", "")
        val res = sharedPref?.getString("rest", "")
        Log.d("AAAA", "$firstName")
        firstNameEdit.setText(firstName)
        secondNameEdit.setText(secondName)
        resEdit.setText(res)


        updateButton.setOnClickListener {
            if(PROMENJENA == 0){
                updateButton.setImageDrawable(context?.let { it1 -> ContextCompat.getDrawable(it1, R.drawable.ic_baseline_save) })
                PROMENJENA = 2
            }
            else if(PROMENJENA == 2){
                updateButton.setImageDrawable(context?.let { it1 -> ContextCompat.getDrawable(it1, R.drawable.ic_baseline_edit) })
                PROMENJENA = 0
            }

        }
        val updateButton_FirstName = view.findViewById<FloatingActionButton>(R.id.floating_first_name)
        updateButton_FirstName.setOnClickListener {
            if(PROMENJENA_IME1 == 0){
                updateButton.setImageDrawable(context?.let { it3 -> ContextCompat.getDrawable(it3, R.drawable.ic_baseline_save) })
                PROMENJENA_IME1 = 2
            }
            else if(PROMENJENA_IME1 == 2){
                updateButton.setImageDrawable(context?.let { it3 -> ContextCompat.getDrawable(it3, R.drawable.ic_baseline_edit) })
                if (sharedPref != null) {
                    with(sharedPref.edit()) {
                        putString("first_name", firstName.toString())
                    }
                }
                PROMENJENA_IME1 = 0
            }
        }
        val updateButton_SecondName = view.findViewById<FloatingActionButton>(R.id.floating_second_name)
        updateButton_SecondName.setOnClickListener {
            if(PROMENJENA_IME2 == 0){
                updateButton_SecondName.setImageDrawable(context?.let { it2 -> ContextCompat.getDrawable(it2, R.drawable.ic_baseline_save) })
                PROMENJENA_IME2 = 2
            }
            else if(PROMENJENA_IME2 == 2){
                updateButton_SecondName.setImageDrawable(context?.let { it2 -> ContextCompat.getDrawable(it2, R.drawable.ic_baseline_edit) })
                if (sharedPref != null) {
                    with(sharedPref.edit()) {
                        putString("second_name", secondName.toString())
                    }
                }
                PROMENJENA_IME2 = 0
            }
        }
        val updateButton_Rest = view.findViewById<FloatingActionButton>(R.id.floating_rest)
        updateButton_Rest.setOnClickListener {
            if(PROMENJENA_RES == 0){
                updateButton_Rest.setImageDrawable(context?.let { it4 -> ContextCompat.getDrawable(it4, R.drawable.ic_baseline_save) })
                PROMENJENA_RES = 2
            }
            else if(PROMENJENA_IME1 == 2){
                updateButton_Rest.setImageDrawable(context?.let { it4 -> ContextCompat.getDrawable(it4, R.drawable.ic_baseline_edit) })
                if (sharedPref != null) {
                    with(sharedPref.edit()) {
                        putString("rest", res.toString())
                    }
                }
                PROMENJENA_RES = 0
            }
        }

        val imageButton = view.findViewById<ImageView>(R.id.user_image)
        imageButton.setOnClickListener {
            if(PROMENJENA == 2) {
                val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                    type = "image/*"
                }

                startActivityForResult(intent, SELECT_IMAGE_REQUEST_CODE)
            }
        }
        
        //TODO: Ovde promeni tekst nakon sto uzmes podatke sa login-a
        /*
        val firstName = view.findViewById<EditText>(R.id.editTextFirstName)
        firstName.setOnClickListener {
            if(PROMENJENA == 0)
            firstName.text =
        }*/
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SELECT_IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val imageUri = data?.data
            updateImageView(imageUri)
        }
    }
    fun updateImageView(imageUri: Uri?){
        val imageView = view?.findViewById<ImageView>(R.id.user_image)
        if (imageView != null) {
            imageView.setImageURI(imageUri)
        }
    }
}