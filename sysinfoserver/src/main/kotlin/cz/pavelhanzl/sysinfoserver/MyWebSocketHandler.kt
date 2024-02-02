package cz.pavelhanzl.sysinfoserver
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

class MyWebSocketHandler: TextWebSocketHandler() {
    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        println(message.payload)
        session.sendMessage(TextMessage("Hello Client!"))
    }
}