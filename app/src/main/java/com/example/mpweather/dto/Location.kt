package com.example.mpweather.dto
import com.google.gson.annotations.SerializedName

data class Location (@SerializedName("name") var city: String) {
    override fun toString(): String {
        return "$city"
    }
}