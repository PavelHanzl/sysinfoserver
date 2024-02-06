package cz.pavelhanzl.sysinfoserver.websocets
import com.google.gson.Gson
import cz.pavelhanzl.sysinfoserver.clients.Client
import cz.pavelhanzl.sysinfoserver.clients.ClientController
import cz.pavelhanzl.sysinfoserver.sysinfo.SysinfoController
import cz.pavelhanzl.sysinfoserver.sysinfo.SysinfoDto
import org.springframework.stereotype.Component
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

@Component
class WebSocketHandler(
    private val sysinfoController: SysinfoController,
    private val clientController: ClientController
) : TextWebSocketHandler() {


    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        println("Incoming message to the server: " + message.payload)
        val payload = message.payload
        convertJsonToDataObjects(payload)
    }

    // Method for converting JSON to object
    private fun convertJsonToDataObjects(json: String) {

        //Client object deserialization
        val gson = Gson()
        val clientDataObject = gson.fromJson(json, Client::class.java)

        //Sysinfo object deserialization to DTO
        val clientsSysinfoDto = gson.fromJson(json, SysinfoDto::class.java)

        //Saves the created objects
        clientController.createClient(clientDataObject)
        sysinfoController.addSysinfo(clientsSysinfoDto)

    }

}