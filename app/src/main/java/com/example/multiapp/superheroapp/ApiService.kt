package com.example.multiapp.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName: String): Response<SuperHeroResponse>
    @GET("{id}")
    suspend fun getSuperheroeDetail(@Path("id")superHeroId: String): Response<com.example.multiapp.superheroapp.SuperheroDetailResponse>
}