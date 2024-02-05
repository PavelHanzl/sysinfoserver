package cz.pavelhanzl.sysinfoserver.clients

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : JpaRepository<Client, Int>{
    fun findByClientName(clientName: String): Client?
}