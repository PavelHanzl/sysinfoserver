package cz.pavelhanzl.sysinfoserver

import cz.pavelhanzl.sysinfoserver.sysinfo.Sysinfo
import cz.pavelhanzl.sysinfoserver.sysinfo.SysinfoRepository
import cz.pavelhanzl.sysinfoserver.users.User
import cz.pavelhanzl.sysinfoserver.users.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class Test(@Autowired private val userRepository: UserRepository, @Autowired private val sysinfoRepository: SysinfoRepository) {
    @RequestMapping("/konzole")
    fun test(){
        val testUser: User = User(1, "Pavel")
        val testSysinfo =Sysinfo(1,testUser, 111.1, 111.1)
        userRepository.save(testUser)
        sysinfoRepository.save(testSysinfo)


        println("Píšu do konzole!")
    }
    }