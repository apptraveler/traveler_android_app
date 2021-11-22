package br.com.traveler.utils

import java.text.NumberFormat
import java.util.*

class NumberFormatter {
    companion object {
        fun getNumberFormatterInstance(): NumberFormat {
            val format = NumberFormat.getCurrencyInstance()
            format.maximumFractionDigits = 0
            format.currency = Currency.getInstance("BRL")
            return format
        }
    }
}