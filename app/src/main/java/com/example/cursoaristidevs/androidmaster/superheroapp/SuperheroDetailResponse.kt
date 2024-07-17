package com.example.cursoaristidevs.androidmaster.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperheroDetailResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("powerstats")
    val powerstats: PowerStatsResponse,
    @SerializedName("image")
    val image: SuperheroImageDetail,
    @SerializedName("biography")
    val biography: Biography,
    @SerializedName("appearance")
    val appearance: Appearance,
)

data class PowerStatsResponse(
    @SerializedName("intelligence")
    val intelligence: String,
    @SerializedName("strength")
    val strength: String,
    @SerializedName("speed")
    val speed: String,
    @SerializedName("durability")
    val durability: String,
    @SerializedName("power")
    val power: String,
    @SerializedName("combat")
    val combat: String,
)

data class SuperheroImageDetail(
    @SerializedName("url")
    val url: String
)

data class Biography(
    @SerializedName("full-name")
    val fullName: String,
    @SerializedName("alter-egos")
    val alterEgos: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("place-of-birth")
    val placeOfBirth: String,
    @SerializedName("first-appearance")
    val firstAppearance: String,
    @SerializedName("alignment")
    val alignment: String
)

data class Appearance(
    @SerializedName("gender")
    val gender: String,
    @SerializedName("race")
    val race: String,
    @SerializedName("height")
    val height: List<String>,
    @SerializedName("weight")
    val weight: List<String>,
    @SerializedName("eye-color")
    val eyeColor: String,
    @SerializedName("hair-color")
    val hairColor: String
)