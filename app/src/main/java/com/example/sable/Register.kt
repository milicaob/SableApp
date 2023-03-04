package com.example.sable

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sable.ui.login.PROMENJENA

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Register.newInstance] factory method to
 * create an instance of this fragment.
 */
class Register : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Register.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Register().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerButton = view.findViewById(R.id.registerButton)

        registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_register_to_mainFragment)
        }
        val passTextRegister = view.findViewById<EditText>(R.id.editTextPasswordRegister)

        registerButton.setOnClickListener {
            val passwordReg = passTextRegister?.text.toString()
            if (TextUtils.isEmpty(passwordReg)){
                //startActivity(intent2)
                val context = this // or getApplicationContext()
                val message = "Password is empty!"
                val duration = Toast.LENGTH_SHORT // or Toast.LENGTH_LONG
                val toast = Toast.makeText(getContext(), message, duration)
                toast.show()
            }
            else {
<<<<<<< HEAD
                // Password is not empty
                // Check if the password meets the desired criteria using a regex
                val passwordPattern = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+\$).{8,}\$")
                if (passwordReg.matches(passwordPattern)) {
                    // Password is okay
                    val first_name = view.findViewById<EditText>(R.id.editTextFirstName)?.text
                    val second_name = view.findViewById<EditText>(R.id.editTextSecondName)?.text
                    val password = view.findViewById<EditText>(R.id.editTextPasswordRegister)?.text
                    val email = view.findViewById<EditText>(R.id.editTextEmailAddress)?.text
                    val rest = view.findViewById<EditText>(R.id.editTextRestaurant)?.text


                    val activity = getActivity()
                    val sharedPref = activity?.getSharedPreferences("my_pref",Context.MODE_PRIVATE)
                    if (sharedPref != null) {
                        with(sharedPref.edit()) {
                            putString("first_name", first_name.toString())
                            putString("second_name", second_name.toString())
                            putString("password", password.toString())
                            putString("email", email.toString())
                            putString("rest", rest.toString())
                            apply()
                        }
                    }
                    findNavController().navigate(R.id.action_register_to_mainFragment)
                } else {
                    // Password is not okay
                    val context = this // or getApplicationContext()
                    val message = "Password is not okay! It should have at least 8 letters, one upper case and one lower case and a number"
                    val duration = Toast.LENGTH_SHORT // or Toast.LENGTH_LONG
=======
                val passwordRepeat =
                    view.findViewById<EditText>(R.id.editTextTextRepeatPassword).text.toString()
                if (passwordReg.equals(passwordRepeat)) {
                    val passwordPattern =
                        Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+\$).{8,}\$")
                    if (passwordReg.matches(passwordPattern)) {
                        val first_name = view.findViewById<EditText>(R.id.editTextFirstName)?.text
                        val second_name = view.findViewById<EditText>(R.id.editTextSecondName)?.text
                        val password =
                            view.findViewById<EditText>(R.id.editTextPasswordRegister)?.text
                        val email = view.findViewById<EditText>(R.id.editTextEmailAddress)?.text
                        val rest = view.findViewById<EditText>(R.id.editTextRestaurant)?.text

                        val activity = getActivity()
                        val sharedPref =
                            activity?.getSharedPreferences("my_pref", Context.MODE_PRIVATE)
                        if (sharedPref != null) {
                            with(sharedPref.edit()) {
                                putString("first_name", first_name.toString())
                                putString("second_name", second_name.toString())
                                putString("password", password.toString())
                                putString("email", email.toString())
                                putString("rest", rest.toString())
                                apply()
                            }
                        }
                        findNavController().navigate(R.id.action_register_to_mainFragment)
                    } else {
                        val message =
                            "Password is not okay! It should have at least 8 letters, one upper case and one lower case and a number"
                        val duration = Toast.LENGTH_SHORT // or Toast.LENGTH_LONG
                        val toast = Toast.makeText(getContext(), message, duration)
                        toast.show()
                    }
                }
                else{
                    val message =
                        "Repeat password is not okay!"
                    val duration = Toast.LENGTH_SHORT
>>>>>>> 6e9cd1e (Gotovo! Male izmene)
                    val toast = Toast.makeText(getContext(), message, duration)
                    toast.show()
                }
            }
        }

<<<<<<< HEAD
        val imageButton = view.findViewById<ImageView>(R.id.imageView)
        imageButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "image/*"
            }

            startActivityForResult(intent, SELECT_IMAGE_REQUEST_CODE)
        }



=======
    }
>>>>>>> 6e9cd1e (Gotovo! Male izmene)

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SELECT_IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // Get the Uri of the selected image
            val imageUri = data?.data
            // Use the Uri to update the image view
            updateImageView(imageUri)
        }
    }
    fun updateImageView(imageUri: Uri?){
        val imageView = view?.findViewById<ImageView>(R.id.imageView)
        if (imageView != null) {
            imageView.setImageURI(imageUri)
        }
    }
}