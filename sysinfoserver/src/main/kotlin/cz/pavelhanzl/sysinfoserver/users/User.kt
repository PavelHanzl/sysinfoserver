package cz.pavelhanzl.sysinfoserver.users

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    var name: String
)