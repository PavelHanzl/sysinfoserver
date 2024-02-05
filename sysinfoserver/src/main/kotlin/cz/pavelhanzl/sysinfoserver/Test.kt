package cz.pavelhanzl.sysinfoserver

import cz.pavelhanzl.sysinfoserver.clients.Client
import cz.pavelhanzl.sysinfoserver.clients.ClientRepository
import cz.pavelhanzl.sysinfoserver.sysinfo.Sysinfo
import cz.pavelhanzl.sysinfoserver.sysinfo.SysinfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class Test(private val userRepository: ClientRepository, @Autowired private val sysinfoRepository: SysinfoRepository) {
    @RequestMapping("/konzole")
    fun test(){
        val testClient = Client(1, "Pavel")
        val testSysinfo =Sysinfo(1,testClient, 111.1, 111.1, 111.1)
        userRepository.save(testClient)
        sysinfoRepository.save(testSysinfo)


        println("Píšu do konzole!")
    }
    }