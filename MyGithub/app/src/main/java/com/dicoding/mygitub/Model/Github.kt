package com.dicoding.mygitub.Model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Repo(

    @SerializedName("description")
    val desc : String,

    @SerializedName("name")
    val nama_repo : String,

    @SerializedName("language")
    val bahasa : String,

    @SerializedName("stargazers_count")
    val star : Int,

    @SerializedName("watchers_count")
    val watch : Int,

    @SerializedName("forks_count")
    val fork : Int,

    @SerializedName("id")
    val id : String,

    @SerializedName("login")
    val username: String,

    @SerializedName("owner")
    val owner : Akun

    )

data class Akun(
    @SerializedName("login")
    val username: String,

    @SerializedName("avatar_url")
    val fotoProfil : String
)