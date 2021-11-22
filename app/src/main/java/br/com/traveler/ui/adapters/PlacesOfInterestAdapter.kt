package br.com.traveler.ui.adapters

import android.content.Context
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.traveler.R
import br.com.traveler.models.PlaceOfInterest
import coil.load
import coil.transform.RoundedCornersTransformation

class PlacesOfInterestAdapter(private val context: Context, private val placesOfInterest: List<PlaceOfInterest>) : RecyclerView.Adapter<PlacesOfInterestAdapter.PlacesOfInterestHolder>() {
    class PlacesOfInterestHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(placeOfInterest: PlaceOfInterest) {
            val placeOfInterestImage = view.findViewById<ImageView>(R.id.placeOfInterestImage)
            placeOfInterestImage.load(placeOfInterest.image) {
                transformations(RoundedCornersTransformation(topLeft = 10f, topRight = 10f))
            }

            val placeOfInterestName = view.findViewById<TextView>(R.id.placeOfInterestName)
            placeOfInterestName.text = placeOfInterest.name

            val placeOfInterestAddress = view.findViewById<TextView>(R.id.placeOfInterestAddress)

            if (placeOfInterest.address.street.isNotEmpty()) {
                placeOfInterestAddress.text = view.resources.getString(R.string.place_of_interest_address_template, placeOfInterest.address.street, placeOfInterest.address.number.toString())
            } else {
                placeOfInterestAddress.visibility = View.GONE
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesOfInterestHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.place_of_interest_item, parent, false)
        return PlacesOfInterestHolder(view)
    }

    override fun onBindViewHolder(holder: PlacesOfInterestHolder, position: Int) {
        holder.bind(placesOfInterest[position])
    }

    override fun getItemCount(): Int {
        return placesOfInterest.size
    }
}

