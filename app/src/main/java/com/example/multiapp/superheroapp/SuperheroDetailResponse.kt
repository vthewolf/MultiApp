package com.example.multiapp.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperheroDetailResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("powerstats")
    val powerstats: com.example.multiapp.superheroapp.PowerStatsResponse,
    @SerializedName("image")
    val image: com.example.multiapp.superheroapp.SuperheroImageDetail,
    @SerializedName("biography")
    val biography: com.example.multiapp.superheroapp.Biography,
    @SerializedName("appearance")
    val appearance: com.example.multiapp.superheroapp.Appearance,
    @SerializedName("work")
    val work: com.example.multiapp.superheroapp.Work,
    @SerializedName("connections")
    val connections: com.example.multiapp.superheroapp.Connections
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

data class Work(
    @SerializedName("occupation")
    val occupation: String,
    @SerializedName("base")
    val base: String,
)

data class Connections(
    @SerializedName("group-affiliation")
    val groupAffiliation: String,
    @SerializedName("relatives")
    val relatives: String,
)