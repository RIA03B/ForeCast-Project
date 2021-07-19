package com.example.mpweather.dao
import com.example.mpweather.dto.Location
import retrofit2.Call
import retrofit2.http.GET

interface ISevenDayWeatherDAO {

    @GET("/core/world-cities/world-cities_json/data/5b3dd46ad10990bca47b04b4739a02ba/world-cities_json.json")
    fun fetchLocation(): Call<ArrayList<Location>>
}
