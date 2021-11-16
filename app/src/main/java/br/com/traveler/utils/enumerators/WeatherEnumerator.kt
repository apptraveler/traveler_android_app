package br.com.traveler.utils.enumerators

import br.com.traveler.utils.Enumerator

class WeatherEnumerator(id: Int, name: String) : Enumerator(id, name) {

    companion object {
        val sunny: WeatherEnumerator = WeatherEnumerator(1, "Ensolarado")
        val hurricaneSeason: WeatherEnumerator = WeatherEnumerator(2, "Temporada de Furacão")
        val wind: WeatherEnumerator = WeatherEnumerator(3, "Ventania")
        val cloudy: WeatherEnumerator = WeatherEnumerator(4, "Nublado")
        val rainy: WeatherEnumerator = WeatherEnumerator(5, "Chuvoso")
        val snowing: WeatherEnumerator = WeatherEnumerator(6, "Nevando")
        val foggy: WeatherEnumerator = WeatherEnumerator(7, "Nebuloso")
        val storm: WeatherEnumerator = WeatherEnumerator(8, "Tempestade")
    }
}