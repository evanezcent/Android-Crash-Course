package com.dicoding.mygitub.Model

import retrofit2.Call
import retrofit2.http.GET

interface Datasource{

    @GET("/users/evanezcent/repos?public")
    fun getRepo():Call<Response>
}