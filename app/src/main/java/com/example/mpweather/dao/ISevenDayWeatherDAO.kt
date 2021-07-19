package com.example.mpweather.dao
import com.example.mpweather.dto.Location
import com.example.mpweather.dto.SevenDayWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ISevenDayWeatherDAO {
    @GET("/data/2.5/weather?q=cincinnati&appid=62985350695c6c5b6f476b823778d5e5")
    fun fetchWeather(): Call<ArrayList<SevenDayWeather>>

    @GET("/core/world-cities/world-cities_json/data/5b3dd46ad10990bca47b04b4739a02ba/world-cities_json.json")
    fun fetchLocation(): Call<ArrayList<Location>>
}
