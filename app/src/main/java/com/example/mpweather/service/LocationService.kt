package com.example.mpweather.service
import retrofit2.Call
import androidx.lifecycle.MutableLiveData
import com.example.mpweather.RetrofitClientInstance
import com.example.mpweather.dao.ISevenDayWeatherDAO
import com.example.mpweather.dto.Location
import retrofit2.Callback
import retrofit2.Response

class LocationService {
    internal fun fetchLocations() : MutableLiveData<ArrayList<Location>>
    {
        var _locations = MutableLiveData<ArrayList<Location>>()
        val service = RetrofitClientInstance.retrofitInstance?.create(ISevenDayWeatherDAO::class.java)
        val call = service?.fetchLocation()
        call?.enqueue(object: Callback<ArrayList<Location>> {
            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<ArrayList<Location>>, t: Throwable)
            {
                val i = 1 + 1;
                val j = 1 + 1;
            }
            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(call: Call<ArrayList<Location>>, response: Response<ArrayList<Location>>)
            {
                _locations.value = response.body()
            }
        })
        return _locations
    }
}