package cz.pavelhanzl.sysinfoserver
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
        println(message.payload)
        val payload = message.payload
        convertJsonToDataObjects(payload) // Převod JSONu na objekt

    }

    // Metoda pro převod JSONu na objekt
    private fun convertJsonToDataObjects(json: String) {
        val gson = Gson()
        val clientDataObject = gson.fromJson(json, Client::class.java)

        val clientsSysinfoDto = gson.fromJson(json, SysinfoDto::class.java)

        println(clientDataObject.clientName) // Výpis pro ověření
        println(clientsSysinfoDto.freeMemory) // Výpis pro ověření

        clientController.createClient(clientDataObject) // Uložení dat do databáze
        sysinfoController.addSysinfo(clientsSysinfoDto)

    }

}