package com.example.cursoaristidevs.androidmaster.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoaristidevs.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superHeroResponse: SuperheroItemResponse, onItemSelected: (String) -> Unit) {
        binding.superheroName.text = superHeroResponse.name
        Picasso.get().load(superHeroResponse.image.url).into(binding.superheroImage)
        binding.root.setOnClickListener { onItemSelected(superHeroResponse.id) }
    }
}