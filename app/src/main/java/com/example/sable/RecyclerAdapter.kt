package com.example.sable

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdapter(private val fragmentManager: FragmentManager, private val poiData: List<Result>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemImage: ImageView
        var itemDetail: TextView
        var cardView : CardView

        init {
            itemImage = itemView.findViewById(R.id.image)
            itemDetail = itemView.findViewById(R.id.item_detail)
            cardView = itemView.findViewById(R.id.card_view)
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val poi = poiData[position]
        val image = poi.images[0]
        val url = image.source_url

        viewHolder.itemDetail.text = poi.name

        Glide.with(viewHolder.itemView).load(url).into(viewHolder.itemImage)
        //viewHolder.itemImage.setImageResource(images[0])



        viewHolder.cardView.setOnClickListener {
            val fragmentTransaction = fragmentManager.beginTransaction()
            val bundle = Bundle()
            bundle.putString("title", poi.name)
            bundle.putString("url", url)
            bundle.putString("desc", poi.snippet)
            val navController = viewHolder.itemView.findNavController()
            navController.navigate(R.id.action_homeF_to_detail, bundle)

            fragmentTransaction.commit()

        }
    }

    override fun getItemCount() = poiData.size

}