package br.com.traveler.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.traveler.R
import br.com.traveler.models.Destination
import br.com.traveler.services.RetrofitInitializer
import br.com.traveler.ui.adapters.DestinationAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        getDestinations()
    }

    fun getDestinations() {
        val destinationService = RetrofitInitializer().getDestinationService()
        val call = destinationService.getDestinations()

        call.enqueue(object : Callback<List<Destination>> {
            override fun onResponse(call: Call<List<Destination>>, response: Response<List<Destination>>) {
                if (!response.isSuccessful) return

                response.body()?.let { destinations -> showDestinations(destinations) }
            }

            override fun onFailure(call: Call<List<Destination>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun showDestinations(destinations: List<Destination>) {
        val destinationView = findViewById<RecyclerView>(R.id.destinations)
        destinationView.adapter = DestinationAdapter(this, destinations)
        destinationView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}