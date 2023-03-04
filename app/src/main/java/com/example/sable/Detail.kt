package com.example.sable

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.sable.databinding.FragmentDetailBinding


class Detail : Fragment() {
    var value : String = ""
    var url : String = ""
    var desc : String = ""

    companion object {
        fun newInstance() = Detail()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        value = arguments?.getString("title").toString()
        url = arguments?.getString("url").toString()
        desc = arguments?.getString("desc").toString()

        Log.d("VALUE", "Value is = $value")

    }
    private lateinit var viewModel: DetailViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        var title: TextView = view.findViewById(R.id.item_title)
        title.text = value

        var image : ImageView = view.findViewById(R.id.image_f)
        Glide.with(view).load(url).into(image)

        var desc_t: TextView = view.findViewById(R.id.item_detail)
        desc_t.text = desc


    }

}