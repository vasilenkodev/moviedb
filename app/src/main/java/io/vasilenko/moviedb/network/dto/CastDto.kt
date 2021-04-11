package io.vasilenko.moviedb.network.dto

import com.google.gson.annotations.SerializedName

data class CastDto(

    @SerializedName("name")
    val name: String?,

    @SerializedName("profile_path")
    val profilePath: String?
)
