package cz.pavelhanzl.sysinfoserver.users

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/users")
class UserController(@Autowired private val userRepository: UserRepository) {

    //get all users
    @GetMapping("")
    fun getAllUsers(): List <User> = userRepository.findAll().toList()

    //create User
    @PostMapping("")
    fun createUser(@RequestBody user: User): ResponseEntity<User>{
        val savedUser = userRepository.save(user)
        return ResponseEntity(savedUser,HttpStatus.CREATED)
    }

    //get user by id


}