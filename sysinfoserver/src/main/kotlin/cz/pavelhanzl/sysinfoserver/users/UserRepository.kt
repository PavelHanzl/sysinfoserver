package cz.pavelhanzl.sysinfoserver.users

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Int>