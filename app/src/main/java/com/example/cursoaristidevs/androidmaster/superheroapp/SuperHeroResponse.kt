package com.example.cursoaristidevs.androidmaster.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroResponse(
    @SerializedName("response")
    val response: String,
    @SerializedName("results")
    val results: List<SuperheroItemResponse>
)

data class SuperheroItemResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: SuperHeroImageResponse
)

data class SuperHeroImageResponse(
    @SerializedName("url")
    val url: String
)
