package br.com.traveler.utils

import android.widget.ImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest

class CoilHelper {
    fun ImageView.loadUrl(url: String) {

        val imageLoader = ImageLoader.Builder(context)
            .componentRegistry { add(SvgDecoder(context)) }
            .build()

        val request = ImageRequest.Builder(context).data(url)
            .target(this)
            .build()

        imageLoader.enqueue(request)
    }
}