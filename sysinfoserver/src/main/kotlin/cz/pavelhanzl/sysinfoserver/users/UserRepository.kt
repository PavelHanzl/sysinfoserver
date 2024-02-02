package cz.pavelhanzl.sysinfoserver.users

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int>