package cz.pavelhanzl.sysinfoserver.clients

import jakarta.persistence.*

@Entity
@Table(name = "clients")
data class Client (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    var clientName: String
)