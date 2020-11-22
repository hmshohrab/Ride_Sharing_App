package com.relevanttech.mapping.simulator

import com.relevanttech.mapping.utils.Constants
import com.google.maps.model.LatLng
import org.json.JSONObject

class WebSocket(private var webSocketListener: WebSocketListener) {

    fun connect() {
        webSocketListener.onConnect()
    }

    fun sendMessage(data: String) {
        val jsonObject = JSONObject(data)
        when (jsonObject.getString("type")) {
            Constants.NEAR_BY_CABS -> {
                Simulator.getFakeNearbyCabLocations(
                    jsonObject.getDouble("lat"),
                    jsonObject.getDouble("lng"),
                    webSocketListener
                )
            }
            Constants.REQUEST_CAB-> {
                val pickUpLatLng =
                    LatLng(jsonObject.getDouble("pickUpLat"), jsonObject.getDouble("pickUpLng"))
                val dropLatLng =
                    LatLng(jsonObject.getDouble("dropLat"), jsonObject.getDouble("dropLng"))
                Simulator.requestCab(
                    pickUpLatLng,
                    dropLatLng,
                    webSocketListener
                )
            }
        }
    }

    fun disconnect() {
        Simulator.stopTimer()
        this.webSocketListener.onDisconnect()
    }

}