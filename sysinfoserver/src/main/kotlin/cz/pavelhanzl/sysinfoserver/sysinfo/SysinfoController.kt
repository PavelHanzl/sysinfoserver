package cz.pavelhanzl.sysinfoserver.sysinfo

import cz.pavelhanzl.sysinfoserver.clients.ClientRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
class SysinfoController(val clientRepository: ClientRepository,
                        val sysinfoRepository: SysinfoRepository) {


    fun addSysinfo(@RequestBody sysinfoDto: SysinfoDto): ResponseEntity<Sysinfo> {

        // Převod DTO na entitu
        val client = clientRepository.findByClientName(sysinfoDto.clientName)
            ?: throw Exception("Klient nenalezen")

        //sestavení sysinfo
        val sysinfo = Sysinfo(
            clientName = client,
            usedMemory = sysinfoDto.usedMemory,
            freeMemory = sysinfoDto.freeMemory,
            totalMemory = sysinfoDto.totalMemory
        )

        //uložení
        sysinfoRepository.save(sysinfo)

        return ResponseEntity.ok(sysinfo)
    }

    @GetMapping("/api/data")
    fun getAllSysinfos(): List <Sysinfo> = sysinfoRepository.findAll().toList()
}