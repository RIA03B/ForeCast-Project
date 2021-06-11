package com.example.mpweather;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
   //Declare the view object refrences
    EditText etCity, etCountry;
    TextView tvResult;
    //Define a final string variable to store the url
    private final String url = "http://api.openweathermap.org/data/2.5/weather";
    //Define a final string variable to store the app id
    private final String appid ="62985350695c6c5b6f476b823778d5e5";
    // Display tempiture in two decimal format design
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get handles for views
        etCity = findViewById(R.id.etCity);
        etCountry = findViewById(R.id.etCountry);
        tvResult= findViewById(R.id.tvResult);

    }

    public void getWeatherDetails(View view) {
    //Define a string to hold the complete url
        String tempUrl = "";
        String city = etCity.getText().toString().trim();
        String country = etCountry.getText().toString().trim();
        //if city field is empty show an error message else complere the url
        if(city.equals("")) {
            tvResult.setText("City field can not be empty!");
        } else {
            if(!country.equals("")) {
                tempUrl = url + "?q=" + city + "," + country + "&appid=" + appid;
            }else{
                tempUrl = url + "?q=" + city + "&appid=" + appid;

            }
            // instantiate a string request object
            StringRequest stringRequest = new StringRequest(Request.Method.POST, tempUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("response","TestingInsideResponse");
                  // Log.d("response", response);
                    //declare variable to store string variable
                    String output = "";
                    //create a json object from the string response
                    try{
                        JSONObject jsonResponse = new JSONObject(response);
                        //Get Json array call weather from Json response
                        JSONArray jsonArray = jsonResponse.getJSONArray("weather");
                        //Get Json object from Json array
                        JSONObject jsonObjectWeather = jsonArray.getJSONObject(0);
                        //Get the value of string description from json object weather
                        String description = jsonObjectWeather.getString("description");
                        //Get Json object from main from Json response
                        JSONObject jsonObjectMain = jsonResponse.getJSONObject("main");
                        //Get the values of temp, pressure, and humidity from Json object main
                        //We subtract it to get temperature in celsius
                        double temp = jsonObjectMain.getDouble("temp") - 273.15;
                        double feelsLike = jsonObjectMain.getDouble("feels_like") - 273.15;
                        float pressure = jsonObjectMain.getInt("pressure");
                        int humidity = jsonObjectMain.getInt("humidity");
                        //Get Json object called wind
                        JSONObject jsonObjectWind = jsonResponse.getJSONObject("wind");
                        //Get the string speed meters per second
                        String wind = jsonObjectWind.getString("speed");
                        //Get the json called clouds
                        JSONObject jsonObjectClouds = jsonResponse.getJSONObject("clouds");
                        //Get the value of string all it represents cloudiness in percentage
                        String clouds = jsonObjectClouds.getString("all");
                        //Get the Json object called sys
                        JSONObject jsonObjectSys = jsonResponse.getJSONObject("sys");
                        //Get the value of the string country
                        String countryName = jsonObjectSys.getString("country");
                        //Get name of city from Json response
                        String cityName = jsonResponse.getString("name");
                        //Change the color of text view
                        tvResult.setTextColor(Color.rgb(68,134,199));
                        // Create the output string by concatenating the necessary variables properly
                        output += "Current weather of "+ cityName+ " ("+countryName +")"
                                    + "\n Temp: "+ df.format(temp)+ "  °C"
                                    + "\n Feels Like: "+ df.format(feelsLike)+ "  °C"
                                    + "\n Humidity: "+ humidity+ "  %"
                                    + "\n Description: "+ description
                                    + "\n Wind Speed: "+ wind+ "m/s (meters per second)"
                                    + "\n Cloudiness: "+ clouds+ "%"
                                    + "\n Pressure: "+ pressure+ "  hPa";
                        // Set text with output
                        tvResult.setText(output);
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {                         Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();

                }

        });
            //Instantiate the request queue
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }
}