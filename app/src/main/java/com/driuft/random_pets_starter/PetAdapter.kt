package com.driuft.random_pets_starter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.NonDisposableHandle.parent

class PetAdapter(thePetList: List<String>): RecyclerView.Adapter<PetAdapter.ViewHolder>(){

    private val petList: List<String> = thePetList

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PetAdapter.ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pet_item, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(parent: PetAdapter.ViewHolder, p1: Int) {
        Glide.with(parent.itemView)
            .load(petList[p1])
            .centerCrop()
            .into(parent.petImage)
        // `holder` can used to reference any View within the RecyclerView item's layout file
        parent.petImage.setOnClickListener {
            Toast.makeText(parent.itemView.context, "Doggo at position $p1 clicked", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount() = petList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val petImage: ImageView

        init {
            // Find our RecyclerView item's ImageView for future use
            petImage = view.findViewById(R.id.pet_image)
        }
    }
}


