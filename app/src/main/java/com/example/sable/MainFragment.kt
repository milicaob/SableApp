package com.example.sable

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var logInButton : TextView

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
        return inflater.inflate(R.layout.fragment_main, container, false)


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent2 = Intent(context, Home::class.java)
        val register_link = view.findViewById<TextView>(R.id.textView2)

        register_link.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_register)
        }
        val passText : EditText = view.findViewById(R.id.editTextTextPassword)
        val emailText : EditText = view.findViewById(R.id.editTextTextEmailAddress)
        logInButton = view.findViewById(R.id.logInButton)
        logInButton.setOnClickListener {
            val password = passText.text.toString()
            val email = emailText.text.toString()
            if (TextUtils.isEmpty(password)){
                //startActivity(intent2)
                val context = this // or getApplicationContext()
                val message = "Password is empty!"
                val duration = Toast.LENGTH_SHORT // or Toast.LENGTH_LONG
                val toast = Toast.makeText(getContext(), message, duration)
                toast.show()
            }
            else {
                val activity = getActivity()

                if(activity != null) {
                    val sharedPref = activity?.getSharedPreferences("my_pref",Context.MODE_PRIVATE)
                    val email_n = sharedPref?.getString("email","")
                    val password_n = sharedPref?.getString("password", "")
                    val rest = sharedPref?.getString("rest", "")

                    if (password_n.equals(password) and email_n.equals(email)){
                        startActivity(intent2)
                    }
                    else{
                        val message = "Password or email is wrong!"
                        val duration = Toast.LENGTH_SHORT
                        val toast = Toast.makeText(getContext(), message, duration)
                        toast.show()
                    }
                }
            }
        }


    }
}