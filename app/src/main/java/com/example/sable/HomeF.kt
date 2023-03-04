package com.example.sable

import android.graphics.BitmapFactory
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeF : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    companion object {
        fun newInstance() = HomeF()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        GlobalScope.launch(Dispatchers.Main) {
            val apiKey = "E9CHL2VB"
            val token = "81vio7opy5th0q8z5b3ch7whyophexp0"
            val locationId = "Paris"
            val tagLabels = "cuisine"
            val triposo = RetrofitClient.getInstance().create(API::class.java)
            val call = triposo.getDog(apiKey, token)

            GlobalScope.launch(Dispatchers.Main) {
                val api = RetrofitClient.getInstance().create(API::class.java)
                val response = api.getDog(apiKey, token)
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        val fragmentManager: FragmentManager = parentFragmentManager
                        adapter =
                            response.body()?.let { RecyclerAdapter(fragmentManager, it.results) }
                        recyclerView?.adapter = adapter
                    }
                } else {
                    Log.d("Error!!", "Response = ${response.isSuccessful}")
                }

            }

        }

    }
}