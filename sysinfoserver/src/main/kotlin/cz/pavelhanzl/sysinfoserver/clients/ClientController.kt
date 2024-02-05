package cz.pavelhanzl.sysinfoserver.clients

import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@Transactional
@RequestMapping("/api/users")
class ClientController(private val clientRepository: ClientRepository) {

    //get all users
    @GetMapping("")
    fun getAllClients(): List <Client> = clientRepository.findAll().toList()

    //create User
    @PostMapping("")
    fun createClient(@RequestBody client: Client): ResponseEntity<Any> {

       if (clientRepository.findByClientName(client.clientName) == null){
           // Klient neexistuje, uložte nového klienta
           val savedClient = clientRepository.save(client)
           return ResponseEntity(savedClient, HttpStatus.CREATED)

       }else{
           return ResponseEntity.status(HttpStatus.CONFLICT).body("Klient s identifikátorem ${client.clientName} již existuje.")
       }



    }


    //get user by id


}