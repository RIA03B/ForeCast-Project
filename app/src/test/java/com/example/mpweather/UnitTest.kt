package com.example.mpweather
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mpweather.dto.Location
import com.example.mpweather.ui.main.MainViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule




class UnitTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    lateinit var mvm: MainViewModel

    @Before
    fun populateCountries() {
        mvm = MainViewModel()

    }

    @Test /*Create a notification and ensure time is set properly.*/
    fun NotificationTimeSet() {

    }

    @Test
    fun countryDTO_maintainsState() {
        var location = Location("Cincinnati")
        assertTrue(location.city == ("Cincinnati"))
    }

    @Test
    fun countryDTO_toStringFormat() {
        var location = Location("Toronto", )
        assertTrue(location.toString() == ("Toronto"))
    }

    @Test
    fun countryDTO_isPopulated() {
        givenViewModelIsInitialized()
        whenJSONDataAreReadAndParsed()
        thenTheCollectionSizeShouldBeGreaterThanZero()
    }

    private fun givenViewModelIsInitialized() {

    }

    private fun whenJSONDataAreReadAndParsed() {
        mvm.fetchLocations()
    }

    private fun thenTheCollectionSizeShouldBeGreaterThanZero() {
        var allLocations = ArrayList<Location>()
        mvm.locations.observeForever {
            allLocations = it
        }
        Thread.sleep(5000)
        assertNotNull(allLocations)
        assertTrue(allLocations.size > 0)
    }
}