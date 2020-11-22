package com.relevanttech.mapping.network

import com.relevanttech.mapping.simulator.WebSocket
import com.relevanttech.mapping.simulator.WebSocketListener


class NetworkService {

    fun createWebSocket(webSocketListener: WebSocketListener): WebSocket {
        return WebSocket(webSocketListener)
    }

}