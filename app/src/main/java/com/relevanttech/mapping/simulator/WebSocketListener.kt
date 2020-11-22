package com.relevanttech.mapping.simulator

interface WebSocketListener {

    fun onConnect()

    fun onMessage(data: String)

    fun onDisconnect()

    fun onError(error: String)

}