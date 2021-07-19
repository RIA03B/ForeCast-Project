package com.example.mpweather.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mpweather.dto.Location
import com.example.mpweather.service.LocationService

class MainViewModel: ViewModel() {
    var locations: MutableLiveData<ArrayList<Location>> = MutableLiveData<ArrayList<Location>>()
    var locationService: LocationService = LocationService()


    init {
        fetchLocations()
    }
    internal fun fetchLocations() {
        locations = locationService.fetchLocations()
    }
}