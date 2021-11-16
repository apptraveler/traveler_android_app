package br.com.traveler.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.traveler.R
import br.com.traveler.models.Destination
import br.com.traveler.utils.enumerators.WeatherEnumerator
import coil.load
import coil.transform.RoundedCornersTransformation

class DestinationAdapter(private val context: Context, private val destinations: List<Destination>) : RecyclerView.Adapter<DestinationAdapter.DestinationHolder>() {

    class DestinationHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(destination: Destination) {
            val destinationImageView = view.findViewById<ImageView>(R.id.destination_image)
            destinationImageView.load(destination.photo) {
                transformations(RoundedCornersTransformation(topLeft = 20f, bottomLeft = 20f))
            }

            val destinationTagsView = view.findViewById<TextView>(R.id.destination_tags)
            destinationTagsView.text = destination.tags.joinToString(", ")

            val destinationNameView = view.findViewById<TextView>(R.id.destination_name)
            destinationNameView.text = view.resources.getString(R.string.destination_template, destination.destination, destination.country)

            setWeatherIcon(destination.weather.id)
            setTourismMeter(destination.tourismLevel)
            setExpenseLevel(destination.expenseLevel)
        }

        private fun setWeatherIcon(weatherId: Int) {
            val destinationWeatherIcon = view.findViewById<ImageView>(R.id.destination_weather_icon)

            when (weatherId) {
                WeatherEnumerator.wind.id -> destinationWeatherIcon.load(R.drawable.wind_cloud)
                WeatherEnumerator.cloudy.id -> destinationWeatherIcon.load(R.drawable.mostly_cloudy_2)
                WeatherEnumerator.foggy.id -> destinationWeatherIcon.load(R.drawable.mist)
                WeatherEnumerator.hurricaneSeason.id -> destinationWeatherIcon.load(R.drawable.tornado_2)
                WeatherEnumerator.rainy.id -> destinationWeatherIcon.load(R.drawable.rain_1)
                WeatherEnumerator.snowing.id -> destinationWeatherIcon.load(R.drawable.snow)
                WeatherEnumerator.storm.id -> destinationWeatherIcon.load(R.drawable.heavy_rain_1)
                WeatherEnumerator.sunny.id -> destinationWeatherIcon.load(R.drawable.sun_1)

            }
        }

        private fun setTourismMeter(tourismLevel: Int) {
            val tourismLevelOne = view.findViewById<ImageView>(R.id.destinationTourismLevelOne)
            val tourismLevelTwo = view.findViewById<ImageView>(R.id.destinationTourismLevelTwo)
            val tourismLevelThree = view.findViewById<ImageView>(R.id.destinationTourismLevelThree)
            val tourismLevelFour = view.findViewById<ImageView>(R.id.destinationTourismLevelFour)
            val tourismLevelFive = view.findViewById<ImageView>(R.id.destinationTourismLevelFive)

            for (i in 1..tourismLevel) {
                when (i) {
                    1 -> tourismLevelOne.load(R.drawable.person_enabled)
                    2 -> tourismLevelTwo.load(R.drawable.person_enabled)
                    3 -> tourismLevelThree.load(R.drawable.person_enabled)
                    4 -> tourismLevelFour.load(R.drawable.person_enabled)
                    5 -> tourismLevelFive.load(R.drawable.person_enabled)
                }
            }
        }

        private fun setExpenseLevel(expenseLevel: Int) {
            val expenseLevelOne = view.findViewById<ImageView>(R.id.expenseLevelOne)
            val expenseLevelTwo = view.findViewById<ImageView>(R.id.expenseLevelTwo)
            val expenseLevelThree = view.findViewById<ImageView>(R.id.expenseLevelThree)
            val expenseLevelFour = view.findViewById<ImageView>(R.id.expenseLevelFour)
            val expenseLevelFive = view.findViewById<ImageView>(R.id.expenseLevelFive)

            for (i in 1..expenseLevel) {
                when (i) {
                    1 -> expenseLevelOne.load(R.drawable.money_enabled)
                    2 -> expenseLevelTwo.load(R.drawable.money_enabled)
                    3 -> expenseLevelThree.load(R.drawable.money_enabled)
                    4 -> expenseLevelFour.load(R.drawable.money_enabled)
                    5 -> expenseLevelFive.load(R.drawable.money_enabled)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.destination_item, parent, false)
        return DestinationHolder(view)
    }

    override fun onBindViewHolder(holder: DestinationHolder, position: Int) {
        holder.bind(destinations[position])
    }

    override fun getItemCount(): Int {
        return destinations.size
    }
}