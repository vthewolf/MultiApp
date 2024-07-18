package com.example.multiapp.superheroapp

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.multiapp.databinding.ActivityDetailSuperheroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

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

    private fun createUi(superhero: com.example.multiapp.superheroapp.SuperheroDetailResponse) {
        Picasso.get().load(superhero.image.url).into(binding.imageSuperhero)
        binding.superheroName.text = superhero.name
        prepareStats(superhero.powerstats)
        binding.superHeroRealName.text = superhero.biography.fullName
        binding.publisher.text = superhero.biography.publisher
        binding.alterEgos.text = superhero.biography.alterEgos
        binding.placeOfBirth.text = superhero.biography.placeOfBirth
        binding.firstAppearance.text = superhero.biography.firstAppearance
        binding.alignment.text = "Alignment: ${superhero.biography.alignment}"
        binding.gender.text = superhero.appearance.gender
        binding.race.text = superhero.appearance.race
        binding.height.text = "Height: ${superhero.appearance.height[1]}"
        binding.weight.text = "Weight: ${superhero.appearance.weight[1]}"
        binding.eyeColor.text = "Eye color: ${superhero.appearance.eyeColor}"
        binding.hairColor.text = "Hair color: ${superhero.appearance.hairColor}"
        binding.occupation.text = "Occupation: ${superhero.work.occupation}"
        binding.base.text = "Base: ${superhero.work.base}"
        binding.groupAffiliation.text = "Group Affiliation: ${superhero.connections.groupAffiliation}"
        binding.relatives.text = "Relatives: ${superhero.connections.relatives}"
    }

    private fun prepareStats(powerstats: com.example.multiapp.superheroapp.PowerStatsResponse) {
        updateHeigh(binding.viewCombat, powerstats.combat)
        updateHeigh(binding.viewPower, powerstats.power)
        updateHeigh(binding.viewSpeed, powerstats.speed)
        updateHeigh(binding.viewStrength, powerstats.strength)
        updateHeigh(binding.viewIntelligence, powerstats.intelligence)
        updateHeigh(binding.viewDurability, powerstats.durability)
    }

    private fun updateHeigh(view: View, stat: String) {
        val params = view.layoutParams
        params.height = pixelToDp(stat.toFloat())
        view.layoutParams = params
    }

    private fun pixelToDp(px: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/3b362a9dbc5bb95b975563f5974f6853/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}