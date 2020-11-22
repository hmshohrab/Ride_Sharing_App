package com.relevanttech.mapping

import android.app.Application
import com.relevanttech.mapping.R
import com.relevanttech.mapping.simulator.Simulator
import com.google.android.libraries.places.api.Places
import com.google.maps.GeoApiContext

class RiderApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Places.initialize(applicationContext, getString(R.string.google_maps_key));
        Simulator.geoApiContext = GeoApiContext.Builder()
            .apiKey(getString(R.string.google_maps_key))
            .build()
    }

}