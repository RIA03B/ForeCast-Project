package com.example.mpweather

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import java.text.DecimalFormat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Define a final string variable to store the url
    private val url = "http://api.openweathermap.org/data/2.5/weather"

    //Define a final string variable to store the app id
    private val appid = "62985350695c6c5b6f476b823778d5e5"

    // Display temperature in two decimal format design
    internal var decimalFormatting = DecimalFormat("#.##")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getWeatherDetails(view: View?) {
        //Define a string to hold the complete url
        var tempUrl = ""
        val city = etCity!!.text.toString().trim { it <= ' ' }
        val country = etCountry!!.text.toString().trim { it <= ' ' }
        //if city field is empty show an error message else complete the url
        if (city == "") {
            tvResult!!.text = "City field can not be empty!"
        } else {
            tempUrl = if (country != "") {
                "$url?q=$city,$country&appid=$appid"
            } else {
                "$url?q=$city&appid=$appid"
            }
            // instantiate a string request object
            val stringRequest = StringRequest(Request.Method.POST, tempUrl, { response ->
                Log.d("response", "TestingInsideResponse")
                // Log.d("response", response);
                //declare variable to store string variable
                var output = ""
                //create a json object from the string response
                try {
                    val jsonResponse = JSONObject(response)
                    //Get Json array call weather from Json response
                    val jsonArray = jsonResponse.getJSONArray("weather")
                    //Get Json object from Json array
                    val jsonObjectWeather = jsonArray.getJSONObject(0)
                    //Get the value of string description from json object weather
                    val description = jsonObjectWeather.getString("description")
                    //Get Json object from main from Json response
                    val jsonObjectMain = jsonResponse.getJSONObject("main")
                    //Get the values of temp, pressure, and humidity from Json object main
                    //We subtract it to get temperature in celsius
                    val temp = jsonObjectMain.getDouble("temp") - TEMP_NUMBER
                    val feelsLike = jsonObjectMain.getDouble("feels_like") - TEMP_NUMBER
                    val pressure = jsonObjectMain.getInt("pressure").toFloat()
                    val humidity = jsonObjectMain.getInt("humidity")
                    //Get Json object called wind
                    val jsonObjectWind = jsonResponse.getJSONObject("wind")
                    //Get the string speed meters per second
                    val wind = jsonObjectWind.getString("speed")
                    //Get the json called clouds
                    val jsonObjectClouds = jsonResponse.getJSONObject("clouds")
                    //Get the value of string all it represents cloudiness in percentage
                    val clouds = jsonObjectClouds.getString("all")
                    //Get the Json object called sys
                    val jsonObjectSys = jsonResponse.getJSONObject("sys")
                    //Get the value of the string country
                    val countryName = jsonObjectSys.getString("country")
                    //Get name of city from Json response
                    val cityName = jsonResponse.getString("name")
                    //Change the color of text view
                    tvResult!!.setTextColor(Color.rgb(0, 0, 0))
                    // Create the output string by concatenating the necessary variables properly
                    output += """Current weather of $cityName ($countryName)
Temp: ${decimalFormatting.format(temp)}  °C
 Feels Like: ${decimalFormatting.format(feelsLike)}  °C
 Humidity: $humidity  %
 Description: $description
 Wind Speed: ${wind}m/s (meters per second)
 Cloudiness: $clouds%
 Pressure: $pressure  hPa"""
                    // Set text with output
                    tvResult!!.text = output
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }) { error ->
                Toast.makeText(
                    applicationContext,
                    error.toString().trim { it <= ' ' },
                    Toast.LENGTH_SHORT
                ).show()
            }
            //Instantiate the request queue
            val requestQueue = Volley.newRequestQueue(applicationContext)
            requestQueue.add(stringRequest)
        }
    }

    //An object that holds the variable for the number that is used to get the tempreture in °C
    companion object{
        const val TEMP_NUMBER = 273.15
    }

}