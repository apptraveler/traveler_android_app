package br.com.traveler.ui.activities

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.traveler.R
import br.com.traveler.models.DestinationProfileInformation
import br.com.traveler.models.PlaceOfInterest
import br.com.traveler.services.RetrofitInitializer
import br.com.traveler.ui.adapters.PlacesOfInterestAdapter
import br.com.traveler.utils.NumberFormatter
import coil.load
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DestinationProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination_profile)

        getDestinationProfile(intent.getIntExtra("destinationId", 0), intent.getIntExtra("tourismLevel", 0))
    }

    private fun getDestinationProfile(destinationId: Int, tourismLevel: Int) {
        val destinationService = RetrofitInitializer().getDestinationsService()
        val call = destinationService.getDestinationProfile()

        call.enqueue(object : Callback<List<DestinationProfileInformation>> {
            override fun onResponse(call: Call<List<DestinationProfileInformation>>, response: Response<List<DestinationProfileInformation>>) {
                if (!response.isSuccessful) return

                response.body()?.let { destinationsInformation ->
                    val destinationInformation = destinationsInformation.firstOrNull { destination -> destination.id == destinationId }
                    destinationInformation?.let { showDestinationInformation(it, tourismLevel) }
                }
            }

            override fun onFailure(call: Call<List<DestinationProfileInformation>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun showDestinationInformation(destinationInformation: DestinationProfileInformation, tourismLevel: Int) {
        val numberFormatter = NumberFormatter.getNumberFormatterInstance()

        val destinationProfileImage = findViewById<ImageView>(R.id.destinationProfileImage)
        destinationProfileImage.load(destinationInformation.image)

        val destinationProfileName = findViewById<TextView>(R.id.destinationProfileName)
        destinationProfileName.text = destinationInformation.name

        val destinationProfileCountry = findViewById<TextView>(R.id.destinationProfileCountry)
        destinationProfileCountry.text = destinationInformation.country

        val destinationProfileAbout = findViewById<TextView>(R.id.destinationProfileAbout)
        destinationProfileAbout.text = destinationInformation.description

        val destinationProfileFiveDaysCost = findViewById<TextView>(R.id.destinationProfileFiveDaysCost)
        destinationProfileFiveDaysCost.text = numberFormatter.format(destinationInformation.averageCost.fiveDays)

        val destinationProfileSevenDaysCost = findViewById<TextView>(R.id.destinationProfileSevenDaysCost)
        destinationProfileSevenDaysCost.text = numberFormatter.format(destinationInformation.averageCost.sevenDays)

        val destinationProfileFifteenDaysCost = findViewById<TextView>(R.id.destinationProfileFifteenDaysCost)
        destinationProfileFifteenDaysCost.text = numberFormatter.format(destinationInformation.averageCost.fifteenDays)

        val destinationProfileWeather = findViewById<TextView>(R.id.destinationProfileWeather)
        destinationProfileWeather.text = destinationInformation.weather.name

        val destinationProfileMinTemperature = findViewById<TextView>(R.id.destinationProfileMinTemperature)
        destinationProfileMinTemperature.text = resources.getString(R.string.temperature_celsius_template, destinationInformation.weather.minTemperature.toString())

        val destinationProfileMaxTemperature = findViewById<TextView>(R.id.destinationProfileMaxTemperature)
        destinationProfileMaxTemperature.text = resources.getString(R.string.temperature_celsius_template, destinationInformation.weather.maxTemperature.toString())

        showDestinationPlaceOfInterest(destinationInformation.placesOfInterest)
        setTourismMeter(tourismLevel)
    }

    private fun showDestinationPlaceOfInterest(placesOfInterest: List<PlaceOfInterest>) {
        val placesOfInterestView = findViewById<RecyclerView>(R.id.placesOfInterestList)
        placesOfInterestView.adapter = PlacesOfInterestAdapter(this, placesOfInterest)
        placesOfInterestView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setTourismMeter(tourismLevel: Int) {
        val tourismLevelOne = findViewById<ImageView>(R.id.destinationTourismProfileLevelOne)
        val tourismLevelTwo = findViewById<ImageView>(R.id.destinationTourismProfileLevelTwo)
        val tourismLevelThree = findViewById<ImageView>(R.id.destinationTourismProfileLevelThree)
        val tourismLevelFour = findViewById<ImageView>(R.id.destinationTourismProfileLevelFour)
        val tourismLevelFive = findViewById<ImageView>(R.id.destinationTourismProfileLevelFive)

        val whiteTint = ContextCompat.getColor(this, R.color.white)

        for (i in 1..tourismLevel) {
            when (i) {
                1 -> {
                    tourismLevelOne.load(R.drawable.person_enabled)
                    ImageViewCompat.setImageTintList(tourismLevelOne, ColorStateList.valueOf(whiteTint))
                }
                2 -> {
                    tourismLevelTwo.load(R.drawable.person_enabled)
                    ImageViewCompat.setImageTintList(tourismLevelTwo, ColorStateList.valueOf(whiteTint))
                }
                3 -> {
                    tourismLevelThree.load(R.drawable.person_enabled)
                    ImageViewCompat.setImageTintList(tourismLevelThree, ColorStateList.valueOf(whiteTint))
                }
                4 -> {
                    tourismLevelFour.load(R.drawable.person_enabled)
                    ImageViewCompat.setImageTintList(tourismLevelFour, ColorStateList.valueOf(whiteTint))
                }
                5 -> {
                    tourismLevelFive.load(R.drawable.person_enabled)
                    ImageViewCompat.setImageTintList(tourismLevelFive, ColorStateList.valueOf(whiteTint))
                }
            }
        }


    }
}