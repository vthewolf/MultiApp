package com.example.cursoaristidevs.androidmaster.superheroapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cursoaristidevs.databinding.ActivityDetailSuperheroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailSuperheroActivity : AppCompatActivity() {

    companion object{
        const val ID = "ID"
    }

    private lateinit var binding: ActivityDetailSuperheroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra(ID).orEmpty()
        getSuperheroInformation(id)
    }

    private fun getSuperheroInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val superheroDetail = getRetrofit().create(ApiService::class.java).getSuperheroeDetail(id)
            if(superheroDetail.body() != null){
                runOnUiThread {
                   createUi(superheroDetail.body()!!)
                }
            }
        }
    }

    private fun createUi(superhero: SuperheroDetailResponse) {
        Picasso.get().load(superhero.image.url).into(binding.imageSuperhero)
        binding.superheroName.text = superhero.name
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/3b362a9dbc5bb95b975563f5974f6853/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}