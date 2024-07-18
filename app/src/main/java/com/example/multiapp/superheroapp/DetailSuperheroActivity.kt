package com.example.multiapp.superheroapp

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.multiapp.R
import com.example.multiapp.databinding.ActivityDetailSuperheroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailSuperheroActivity : AppCompatActivity() {

    companion object {
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
            val superheroDetail =
                getRetrofit().create(ApiService::class.java).getSuperheroeDetail(id)
            if (superheroDetail.body() != null) {
                runOnUiThread {
                    createUi(superheroDetail.body()!!)
                }
            }
        }
    }

    private fun createUi(superhero: SuperheroDetailResponse) {
        Picasso.get().load(superhero.image.url).into(binding.imageSuperhero)
        prepareStats(superhero.powerstats)
        with(binding) {
            superheroName.text = superhero.name
            superHeroRealName.text = superhero.biography.fullName
            publisher.text = superhero.biography.publisher
            alterEgos.text = superhero.biography.alterEgos
            placeOfBirth.text = superhero.biography.placeOfBirth
            firstAppearance.text = superhero.biography.firstAppearance
            gender.text = superhero.appearance.gender
            race.text = superhero.appearance.race
            alignment.text = String.format(
                getString(R.string.superhero_alignment),
                superhero.biography.alignment
            )
            height.text = String.format(
                getString(R.string.superhero_height),
                superhero.appearance.height[1]
            )
            weight.text = String.format(
                getString(R.string.superhero_weight),
                superhero.appearance.weight[1]
            )
            eyeColor.text = String.format(
                getString(R.string.superhero_eye_color),
                superhero.appearance.eyeColor
            )
            hairColor.text = String.format(
                getString(R.string.superhero_hair_color),
                superhero.appearance.hairColor
            )
            occupation.text = String.format(
                getString(R.string.superhero_occupation),
                superhero.work.occupation
            )
            base.text = String.format(
                getString(R.string.superhero_base),
                superhero.work.base
            )
            groupAffiliation.text = String.format(
                getString(R.string.superhero_group_affiliation),
                superhero.connections.groupAffiliation
            )
            relatives.text = String.format(
                getString(R.string.superhero_relatives),
                superhero.connections.relatives
            )
            alignment.text = String.format(
                getString(R.string.superhero_alignment),
                superhero.biography.alignment
            )
        }
    }

    private fun prepareStats(powerstats: PowerStatsResponse) {
        with(binding) {
            updateHeigh(viewCombat, powerstats.combat)
            updateHeigh(viewPower, powerstats.power)
            updateHeigh(viewSpeed, powerstats.speed)
            updateHeigh(viewStrength, powerstats.strength)
            updateHeigh(viewIntelligence, powerstats.intelligence)
            updateHeigh(viewDurability, powerstats.durability)
        }
    }

    private fun updateHeigh(view: View, stat: String) {
        val params = view.layoutParams
        params.height = pixelToDp(stat.toFloat())
        view.layoutParams = params
    }

    private fun pixelToDp(px: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics)
            .roundToInt()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/3b362a9dbc5bb95b975563f5974f6853/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}