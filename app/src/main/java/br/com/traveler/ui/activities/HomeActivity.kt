package br.com.traveler.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
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

    lateinit var destinationsList: List<Destination>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        getDestinations()
    }

    private fun getDestinations() {
        val destinationService = RetrofitInitializer().getDestinationsService()
        val call = destinationService.getDestinations()

        call.enqueue(object : Callback<List<Destination>> {
            override fun onResponse(call: Call<List<Destination>>, response: Response<List<Destination>>) {
                if (!response.isSuccessful) return

                response.body()?.let { destinations ->
                    destinationsList = destinations
                    showDestinations(destinations)
                }
            }

            override fun onFailure(call: Call<List<Destination>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun showDestinations(destinations: List<Destination>) {
        val destinationView = findViewById<RecyclerView>(R.id.destinations)
        val adapter = DestinationAdapter(this, destinations)

        configureSearchBar(adapter)

        destinationView.adapter = adapter
        destinationView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun configureSearchBar(adapter: DestinationAdapter) {
        val searchBar = findViewById<SearchView>(R.id.searchDestinations)

        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return false
            }
        })

    }
}