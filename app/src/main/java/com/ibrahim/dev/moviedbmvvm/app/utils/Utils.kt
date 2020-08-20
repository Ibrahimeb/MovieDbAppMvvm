package com.ibrahim.dev.moviedbmvvm.app.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    fun hasNetwork(context: Context): Boolean {
        var isConnected = false // Initial Value
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }

    @SuppressLint("SimpleDateFormat")
    fun parseStringDate(date: String): Date {
        val format = SimpleDateFormat("yyyy-MM-dd")
        return format.parse(date) ?: Date()
    }

    fun getYear(date: Date): Int {
        val c = Calendar.getInstance()
        c.time = date // yourdate is an object of type Date
        return c.get(Calendar.YEAR)
    }

    fun getImageUrlMedium(path: String) = "https://image.tmdb.org/t/p/w300$path"
    fun getImageUrlLarge(path: String) = "https://image.tmdb.org/t/p/w500$path"

    fun timebyNewRequest(timeModel: Timestamp, typeDiference: Int): Long {
        val diff = timeModel.time - Timestamp(System.currentTimeMillis()).time
        val second = diff / 1000
        val minuts = second / 60
        val hour = minuts / 60
        val dias: Long = hour / 24


        return when (typeDiference) {
            Calendar.SECOND -> second
            Calendar.MINUTE -> minuts
            else -> hour
        }
    }

}