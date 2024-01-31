package cz.pavelhanzl.sysinfoserver

import cz.pavelhanzl.sysinfoserver.users.User
import cz.pavelhanzl.sysinfoserver.users.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class Test(@Autowired private val userRepository: UserRepository) {
    @RequestMapping("/konzole")
    fun test(){
        val testUser: User = User(1, "Pavel")
        userRepository.save(testUser)


        println("Píšu do konzole.")
    }
    }